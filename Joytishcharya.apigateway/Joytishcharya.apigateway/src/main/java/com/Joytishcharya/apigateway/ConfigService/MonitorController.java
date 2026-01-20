package com.Joytishcharya.apigateway.ConfigService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/monitor")
public class MonitorController {

    private final WebClient webClient;

    public MonitorController(WebClient.Builder builder) {
        this.webClient = builder.build();
    }

    // List of all microservices
    private static final List<String> SERVICES = List.of(
            "JOYTISHCHARYA.USERSERVICE",
            "ORDER-SERVICE",
            "PAYMENT-SERVICE"
    );

    @GetMapping("/health")
    public Mono<Map<String, String>> healthCheckAll() {

        Map<String, Mono<String>> calls = new HashMap<>();

        for (String service : SERVICES) {
            calls.put(service, checkHealth(service));
        }

        return Mono.zip(calls.values(), results -> {
            Map<String, String> response = new HashMap<>();
            int i = 0;
            for (String service : calls.keySet()) {
                response.put(service, (String) results[i++]);
            }
            return response;
        });
    }

    private Mono<String> checkHealth(String serviceName) {
        return webClient.get()
                .uri("http://" + serviceName + "/actuator/health")
                .retrieve()
                .bodyToMono(Map.class)
                .map(res -> res.get("status").toString())
                .onErrorReturn("DOWN");
    }
}

