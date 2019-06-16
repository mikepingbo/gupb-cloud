package com.gupb.gateway.filter;

import java.nio.charset.StandardCharsets;

import com.gupb.util.page.WrapMapperResult;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.alibaba.fastjson.JSON;

import reactor.core.publisher.Mono;

/**
 * 鉴权
 */
@Component
public class AuthFilter implements GlobalFilter{
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // TODO 鉴权逻辑
//        String token = exchange.getRequest().getHeaders().getFirst("token");
//        if ("token".equals(token)) {
//            return chain.filter(exchange);
//        }
//
//        ServerHttpResponse response = exchange.getResponse();
//        WrapMapperResult data = new WrapMapperResult();
//        data.setCode("401");
//        data.setMessage("非法请求");
//        byte[] datas = JSON.toJSONString(data).getBytes(StandardCharsets.UTF_8);
//        DataBuffer buffer = response.bufferFactory().wrap(datas);
//        response.setStatusCode(HttpStatus.UNAUTHORIZED);
//        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
//        return response.writeWith(Mono.just(buffer));

        // 继续往下执行
        return chain.filter(exchange);
    }
}
