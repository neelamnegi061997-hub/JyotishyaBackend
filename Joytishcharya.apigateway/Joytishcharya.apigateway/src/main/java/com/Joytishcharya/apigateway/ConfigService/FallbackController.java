package com.Joytishcharya.apigateway.ConfigService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FallbackController {

    @GetMapping("/fallback/user")
    public Mono<Map<String, Object>> userFallback() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "DOWN");
        response.put("message", "User service is temporarily unavailable");
        return Mono.just(response);
    }
}

