package com.gupb.gateway.filter;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Set;

import com.gupb.gateway.utils.GatewayRedisUtils;
import com.gupb.util.page.WrapMapperResult;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;

import com.alibaba.fastjson.JSON;

import reactor.core.publisher.Mono;

/**
 * 鉴权
 */
@Component
public class AuthFilter implements GlobalFilter{

    public final static Logger logger = LoggerFactory.getLogger(AuthFilter.class);

    @Autowired
    private GatewayRedisUtils gatewayRedisUtils;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // TODO 鉴权逻辑
//        String token = exchange.getRequest().getHeaders().getFirst("token");
//        if ("token".equals(token)) {
//            return chain.filter(exchange);
//        }

//        URI uri = exchange.getRequest().getURI();
//        String uriPath = uri.getPath();
//        if (uriPath.compareTo("rpc") == -1) {
//            ServerHttpResponse response = exchange.getResponse();
//            WrapMapperResult data = new WrapMapperResult();
//            data.setCode("401");
//            data.setMessage("非法请求");
//            byte[] datas = JSON.toJSONString(data).getBytes(StandardCharsets.UTF_8);
//            DataBuffer buffer = response.bufferFactory().wrap(datas);
//            response.setStatusCode(HttpStatus.UNAUTHORIZED);
//            response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
//            return response.writeWith(Mono.just(buffer));
//        }

        // 权限判断
        URI uri = exchange.getRequest().getURI();
        String uriPath = uri.getPath();
        // 字符串转数组
        String[] urlPathArray = uriPath.split("/");
        // 获取url中最后一个字段
        String lastStr = urlPathArray[urlPathArray.length - 1];
        // 数组中第二个字段
        String secondStr = urlPathArray[2];

        // swagger判断
        if (StringUtils.equals("api-docs", lastStr)) {
            return chain.filter(exchange);
        }

        if (!checkAuthority(exchange, secondStr, uriPath)) {
            ServerHttpResponse response = exchange.getResponse();
            WrapMapperResult data = new WrapMapperResult();
            data.setCode("401");
            data.setMessage("非法请求");
            byte[] datas = JSON.toJSONString(data).getBytes(StandardCharsets.UTF_8);
            DataBuffer buffer = response.bufferFactory().wrap(datas);
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
            return response.writeWith(Mono.just(buffer));
        }

        // 继续往下执行
        return chain.filter(exchange);
    }

    public boolean checkAuthority(ServerWebExchange exchange, String productName, String uriPath) {
        Set<String> urlSet = gatewayRedisUtils.getObject("gupbcloud-" + productName + "_frontend_urls", Set.class);
        if (urlSet == null) {
            logger.info("gupbcloud-" + productName + "服务C端权限校验数据为空，请赶紧处理！");
            return false;
        }

        boolean roleFlag = false;
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        for (String url : urlSet) {
            if (antPathMatcher.match(url, uriPath)) {
                roleFlag = true;
                break;
            }
        }
        if (roleFlag) {
            return true;
        }

        // 网关处理逻辑异常
        logger.info("想要访问吗？哼哼...不让！！！");
        return false;
    }
}
