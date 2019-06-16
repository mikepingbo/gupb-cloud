//package com.gupb.gateway.filter;
//
//import java.nio.charset.Charset;
//
//import com.gupb.util.page.WrapMapperResult;
//import org.reactivestreams.Publisher;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.core.io.buffer.DataBuffer;
//import org.springframework.core.io.buffer.DataBufferFactory;
//import org.springframework.core.io.buffer.DataBufferUtils;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//
//import com.alibaba.fastjson.JSON;
//
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//@Component
//public class WrapperResponseFilter implements GlobalFilter, Ordered {
//    @Override
//    public int getOrder() {
//        // -1 is response write filter, must be called before that
//        return -2;
//    }
//    // TODO 返回结果格式，统一设置
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        ServerHttpResponse originalResponse = exchange.getResponse();
//        DataBufferFactory bufferFactory = originalResponse.bufferFactory();
//        ServerHttpResponseDecorator decoratedResponse = new ServerHttpResponseDecorator(originalResponse) {
//            @Override
//            public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {
//                if (body instanceof Flux) {
//                    Flux<? extends DataBuffer> fluxBody = (Flux<? extends DataBuffer>) body;
//                    return super.writeWith(fluxBody.map(dataBuffer -> {
//                        // probably should reuse buffers
//                        byte[] content = new byte[dataBuffer.readableByteCount()];
//                        dataBuffer.read(content);
//                        // 释放掉内存
//                        DataBufferUtils.release(dataBuffer);
//                        String rs = new String(content, Charset.forName("UTF-8"));
//                        WrapMapperResult response = new WrapMapperResult();
//                        response.setCode("1");
//                        response.setMessage("请求成功");
//                        response.setData(rs);
//
//                        byte[] newRs = JSON.toJSONString(response).getBytes(Charset.forName("UTF-8"));
//                        originalResponse.getHeaders().setContentLength(newRs.length);//如果不重新设置长度则收不到消息。
//                        return bufferFactory.wrap(newRs);
//                    }));
//                }
//                // if body is not a flux. never got there.
//                return super.writeWith(body);
//            }
//        };
//        // replace response with decorator
//        return chain.filter(exchange.mutate().response(decoratedResponse).build());
//    }
//}