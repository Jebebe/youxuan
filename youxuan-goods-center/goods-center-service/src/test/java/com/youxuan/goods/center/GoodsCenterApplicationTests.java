package com.youxuan.goods.center;

import com.youxuan.common.utils.redis.RedisUtils;
import com.youxuan.goods.center.api.result.CategoryListResultDTO;
import com.youxuan.goods.center.mapper.CategoryMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootConfiguration
@EnableAutoConfiguration
@EnableEurekaClient
@EnableDiscoveryClient
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GoodsCenterApplicationTests.class)
@MapperScan("com.youxuan.goods.center.mapper")
@ComponentScan(basePackages = {"com.youxuan.goods.center", "com.youxuan.common.utils.redis"})
public class GoodsCenterApplicationTests {

}
