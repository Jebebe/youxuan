package com.youxuan.eureka.register.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaRegisterService2Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaRegisterService2Application.class, args);
    }
}