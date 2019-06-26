package com.gupb.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 根据用户的维度去限流
 */
public class UserKeyResolver implements KeyResolver {

    public static final String BEAN_NAME = "userKeyResolver";

    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        return Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
    }
}
