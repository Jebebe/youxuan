package com.youxuan.goods.center;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@MapperScan("com.youxuan.goods.center.mapper")
public class GoodsCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsCenterApplication.class, args);
    }
}
