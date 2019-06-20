package com.gupb.rpc.configuration;

import com.gupb.rpc.feign.GupbFeignBeanPostProcessor;
import com.gupb.rpc.feign.GupbFeignInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Gupb rest template configuration.
 *
 * @author gupb
 */
@Configuration
public class GupbFeignConfiguration {

    /**
     * Request interceptor request interceptor.
     *
     * @return the request interceptor
     */
    @Bean
    public RequestInterceptor requestInterceptor() {
        return new GupbFeignInterceptor();
    }

    /**
     * gupbFeign post processor gupb feign bean post processor.
     *
     * @return the gupb feign bean post processor
     */
    @Bean
    public GupbFeignBeanPostProcessor gupbFeignPostProcessor() {
        return new GupbFeignBeanPostProcessor();
    }
}
