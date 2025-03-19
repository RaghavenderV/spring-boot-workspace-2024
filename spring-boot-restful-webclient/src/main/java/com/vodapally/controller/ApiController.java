package com.vodapally.controller;

import com.vodapally.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/posts")
public class ApiController {
    @Autowired
    private ApiService apiService;

    @GetMapping("/{id}")
    public Mono<String> getPostById(@PathVariable int id) {
        return apiService.getPostById(id);
    }

    @PostMapping
    public Mono<String> createPost(@RequestParam String title,
                                   @RequestParam String body,
                                   @RequestParam int userId) {
        return apiService.createPost(title, body, userId);
    }

    @PutMapping("/{id}")
    public Mono<String> updatePost(@PathVariable int id,
                                   @RequestParam String title,
                                   @RequestParam String body,
                                   @RequestParam int userId) {
        return apiService.updatePost(id, title, body, userId);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deletePost(@PathVariable int id) {
        return apiService.deletePost(id);
    }

}
