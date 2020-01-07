package com.youxuan.goods.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.youxuan.goods.service.mapper")
public class GoodsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsServiceApplication.class, args);
    }
}
