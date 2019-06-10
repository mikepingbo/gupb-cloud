package com.gupb.rpc.configuration;

import com.gupb.rpc.feign.GupbFeignBeanPostProcessor;
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
     * gupbFeign post processor gupb feign bean post processor.
     *
     * @return the gupb feign bean post processor
     */
    @Bean
    public GupbFeignBeanPostProcessor gupbFeignPostProcessor() {
        return new GupbFeignBeanPostProcessor();
    }
}
