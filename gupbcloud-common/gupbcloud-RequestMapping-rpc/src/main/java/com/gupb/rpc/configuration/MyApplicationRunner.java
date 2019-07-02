package com.gupb.rpc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${server.port:8080}")
    private String serverPort;

    @Override
    public void run(ApplicationArguments var1) throws Exception{
        System.out.println("MyApplicationRunner class will be execute when the project was started!");
        System.out.println("http://localhost:" + serverPort + "/mapping/allurl");
        restTemplate.getForObject("http://localhost:" + serverPort + "/mapping/allurl", String.class);
    }
}
