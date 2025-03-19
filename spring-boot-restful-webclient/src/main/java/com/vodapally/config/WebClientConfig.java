package com.vodapally.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Configuration
public class WebClientConfig {
    private static final Logger log = LoggerFactory.getLogger(WebClientConfig.class);
    @Bean
    public WebClient webClient(){
        return WebClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .defaultHeaders(headers -> headers.setBasicAuth("raghu","vihaan"))
                .filter(logRequest())
                .filter(logResponse())
                .build();
    }


    private ExchangeFilterFunction logRequest() {
        return ExchangeFilterFunction.ofRequestProcessor(clientRequest ->
        {
            log.info("Request : {} {}",clientRequest.method(),clientRequest.url());
            return Mono.just(clientRequest);
        });

    }

    private ExchangeFilterFunction logResponse() {
        return ExchangeFilterFunction.ofResponseProcessor(clientResponse->
        {
            log.info("Response: {}",clientResponse.statusCode());
            return Mono.just(clientResponse);
        });
    }
}
