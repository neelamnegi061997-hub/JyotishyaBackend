package com.Joytishcharya.apigateway.ConfigService;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;
import org.springframework.context.annotation.Configuration;


@Configuration
public class UserKeyResolverConfig {

    @Bean
    public KeyResolver userKeyResolver() {
        return exchange ->
                Mono.just(
                        exchange.getRequest()
                                .getRemoteAddress()
                                .getAddress()
                                .getHostAddress()
                );
    }
}
