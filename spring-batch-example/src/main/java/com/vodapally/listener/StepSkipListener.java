package com.vodapally.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vodapally.entity.Customer;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.SkipListener;

public class StepSkipListener implements SkipListener<Customer, Number> {
    Logger logger = LoggerFactory.getLogger(StepSkipListener.class);

    @Override
    public void onSkipInRead(Throwable t) {
        logger.info("A failure on read {}", t.getMessage());
    }

    //@SneakyThrows
    @Override
    public void onSkipInProcess(Customer customer, Throwable t) {
        try {
            logger.info("Item {} was skipped due to the exception {} ",
                    new ObjectMapper().writeValueAsString(customer), t.getMessage());
        } catch (JsonProcessingException e) {
            System.out.println("Exception occurred while parsing --> "+e.getMessage());
        }
    }

    @Override
    public void onSkipInWrite(Number item, Throwable t) {
        logger.info("A failure on write {}, {}", t.getMessage(), item);
    }
}
