package com.vodapally.controller;

import com.vodapally.client.WorkerClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
@RequestMapping("/worker")
public class WorkerController {
    //@Autowired
    //private RestTemplate restTemplate;

    @Autowired
    private WorkerClient workerClient;

    int count = 1;
    private static final String BASE_URL = "http://localhost:9092";
    private static final String WORKER = "worker";

    @GetMapping
    @CircuitBreaker(name = WORKER, fallbackMethod = "workerFallback")
    @Retry(name = WORKER)
    @RateLimiter(name = WORKER)
    public String worker(){
        System.out.println("Retry method called "+count+++" times at "+new Date());
        //String url = BASE_URL+"/company";
        //return restTemplate.getForObject(url, String.class);
        return workerClient.worker();
    }

    public String workerFallback(Exception e){
        return "This is a fallbackMethod for worker microservice";
    }
}
