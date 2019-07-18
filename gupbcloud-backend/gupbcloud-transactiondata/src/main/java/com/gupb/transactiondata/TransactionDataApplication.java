package com.gupb.transactiondata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.gupb")
@EnableHystrix
@EnableHystrixDashboard
public class TransactionDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionDataApplication.class, args);
    }
}
