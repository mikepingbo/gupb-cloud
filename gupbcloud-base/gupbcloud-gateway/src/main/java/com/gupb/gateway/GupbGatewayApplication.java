package com.gupb.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "com.gupb")
@EnableDiscoveryClient
public class GupbGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GupbGatewayApplication.class, args);
    }
}
