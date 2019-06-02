package com.gupb.feign;

import com.gupb.hystrix.FeignHystrixConcurrencyStrategy;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
public class FeignConfig implements RequestInterceptor {

    @Bean
    public FeignHystrixConcurrencyStrategy feignHystrixConcurrencyStrategy() {
        return new FeignHystrixConcurrencyStrategy();
    }

    public void apply(RequestTemplate requestTemplate) {
        // requestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        // get request
        HttpServletRequest request = requestAttributes == null ? null : ((ServletRequestAttributes)requestAttributes).getRequest();

        if (request != null) {
            requestTemplate.header("sessionId", "testtoken");
        }
    }
}
