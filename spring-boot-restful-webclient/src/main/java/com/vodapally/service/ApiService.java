package com.vodapally.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
public class ApiService {

    @Autowired
    private WebClient webClient;

    // Get Request with error handling
    public Mono<String> getPostById(int id) {
        return webClient.get()
                .uri("/posts/{id}", id)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response ->
                        Mono.error(new RuntimeException("Client error: " + response.statusCode())))
                .onStatus(HttpStatusCode::is5xxServerError, response ->
                        Mono.error(new RuntimeException("Server Error: " + response.statusCode())))
                .bodyToMono(String.class)
                .doOnError(WebClientResponseException.class,
                        ex -> System.err.println(ex.getResponseBodyAsString()));
    }

    // POST Request with error handling
    public Mono<String> createPost(String title, String body, int userId) {
        return webClient.post()
                .uri("/posts")
                .bodyValue(new PostRequest(title, body, userId))
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(WebClientResponseException.class,
                        ex -> {
                            System.err.println("Error: " + ex.getResponseBodyAsString());
                            return Mono.empty();
                        });
    }

    public Mono<String> updatePost(int id, String title, String body, int userId) {
        return webClient.put()
                .uri("/posts/{id}", id)
                .bodyValue(new PostRequest(title, body, userId))
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<Void> deletePost(int id) {
        return webClient.delete()
                .uri("/posts/{id}", id)
                .retrieve()
                .onStatus(HttpStatusCode::isError, response ->
                        Mono.error(new RuntimeException("Error deleting post: " + response.statusCode())))
                .bodyToMono(Void.class);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class PostRequest {
        private String title;
        private String body;
        private int userId;
    }
}
