package com.Joytishcharya.apigateway.ConfigService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @GetMapping("/fallback/user")
    public Mono<String> userFallback() {
        return Mono.just("User service is temporarily unavailable");
    }
}

