package com.vodapally.controller;

import com.vodapally.entity.Customer;
import com.vodapally.repository.CustomerRepository;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @Autowired
    private CustomerRepository repository;

    private final String TEMP_STORAGE = "G:\\spring-boot-workspace-2024\\spring-batch-example\\src\\main\\resources";

    @PostMapping("/importCustomers")
    public ResponseEntity<String> importCsvToDBJob(@RequestParam("file")MultipartFile multipartFile){
        try {
        String originalFileName = multipartFile.getOriginalFilename();
        File fileToImport = new File(TEMP_STORAGE+originalFileName);
        multipartFile.transferTo(fileToImport);
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("fullPathFileName",fileToImport.getAbsolutePath())
                .addLong("startAt --> ", System.currentTimeMillis())
                .toJobParameters();

            JobExecution jobExecution = jobLauncher.run(job, jobParameters);

            return ResponseEntity.ok("Imported customers from CSV to MySQL DB Successfully!!");
        }

        catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
               | JobParametersInvalidException | IOException e) {
            e.printStackTrace();

            //return ResponseEntity.ok("Exception occurred while processing : "+e.getMessage());

        }
        return ResponseEntity.ok("Exception occurred while processing .. ");


    }

    @GetMapping("/getCustomers")
    public List<Customer> getAll(){
        return repository.findAll();
    }
}
