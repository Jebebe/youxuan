package com.youxuan.goods.center.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Jebe
 * @Date: 2019/12/25
 * @Desc Redis配置
 */
// @Configuration
// @Setter
// @Getter
public class RedisConfig {

    @Value("${spring.redis.host}")
    private String redisUrl;

    @Value("${spring.redis.port}")
    private String port;

    @Value("${spring.redis.password}")
    private String redisPassword;

    @Value("${spring.redis.database.sync}")
    private int redisDatabase;

    @Value("${spring.redis.timeout}")
    private int redisTimeout;

    // @Bean
    /*public RedissonClient getRedissonClient() {
        //创建配置信息
        Config config = new Config();
        config.useSingleServer().setAddress("redis://" + redisUrl + ":" + port)
                .setPassword(redisPassword)
                .setDatabase(redisDatabase)
                .setConnectTimeout(redisTimeout)
                .setTimeout(redisTimeout);
        return Redisson.create(config);
    }*/
}