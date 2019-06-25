package com.gupb.gateway;

import com.gupb.gateway.config.HostAddrKeyResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "com.gupb")
@EnableDiscoveryClient
@RestController
public class GupbGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GupbGatewayApplication.class, args);
    }

    /**
     * 根据Hostname进行限流
     *
     * @return
     */
    @Bean
    public HostAddrKeyResolver hostAddrKeyResolver() {
        return new HostAddrKeyResolver();
    }
}
