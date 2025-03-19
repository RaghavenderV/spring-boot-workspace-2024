package com.vodapally.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "http://localhost:9092", name = "WORKER-CLIENT")
public interface WorkerClient {

    @GetMapping("/company")
    String worker();

}
