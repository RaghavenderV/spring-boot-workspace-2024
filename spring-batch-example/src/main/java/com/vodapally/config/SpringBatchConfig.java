package com.vodapally.config;

import com.vodapally.entity.Customer;
import com.vodapally.listener.StepSkipListener;
import com.vodapally.repository.CustomerRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.SkipListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.skip.SkipPolicy;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

import java.io.File;

@Configuration
public class SpringBatchConfig {

    private CustomerRepository customerRepository;
    private JobRepository jobRepository;
    private PlatformTransactionManager transactionManager;
    private CustomerItemWriter customerItemWriter;

    public SpringBatchConfig(CustomerRepository customerRepository, JobRepository jobRepository, PlatformTransactionManager transactionManager, CustomerItemWriter customerItemWriter) {
        this.customerRepository = customerRepository;
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
        this.customerItemWriter = customerItemWriter;
    }

    @Bean
    @StepScope
    public FlatFileItemReader<Customer> itemReader(@Value("#{jobParameters[fullPathFileName]}") String pathToFile) {
        FlatFileItemReader<Customer> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(new FileSystemResource(new File(pathToFile)));
        itemReader.setName("CSV-Reader");
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(lineMapper());
        return itemReader;
    }

    private LineMapper<Customer> lineMapper() {
        DefaultLineMapper<Customer> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("id", "firstName", "lastName", "email", "gender", "contactNo", "country", "dob", "age");

        BeanWrapperFieldSetMapper<Customer> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Customer.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        return lineMapper;
    }

    @Bean
    public CustomerProcessor processor() {
        return new CustomerProcessor();
    }

    @Bean
    public RepositoryItemWriter<Customer> writer() {
        RepositoryItemWriter<Customer> itemWriter = new RepositoryItemWriter<>();
        itemWriter.setRepository(customerRepository);
        itemWriter.setMethodName("save");

        return itemWriter;
    }

    @Bean
    public Step step1(FlatFileItemReader<Customer> itemReader) {
        return new StepBuilder("slaveStep", jobRepository)
                .<Customer, Customer>chunk(5, transactionManager)
                .reader(itemReader)
                .processor(processor())
                .writer(customerItemWriter)
                .faultTolerant()
                .skipPolicy(skipPolicy())
                .listener(skipListener())
                //.taskExecutor(taskExecutor())
                .build();
    }

    private SkipListener skipListener() {
        return new StepSkipListener();

    }

    private SkipPolicy skipPolicy() {
        return new ExceptionSkipPolicy();
    }

    @Bean
    public TaskExecutor taskExecutor() {
        SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
        asyncTaskExecutor.setConcurrencyLimit(10);
        return asyncTaskExecutor;
    }

    @Bean
    public Job runJob(FlatFileItemReader<Customer> itemReader) {
        return new JobBuilder("importCustomers", jobRepository)
                .start(step1(itemReader))
                .build();
    }
}
