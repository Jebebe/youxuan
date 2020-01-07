package com.youxuan.goods.center.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: Jebe
 * @Date: 2019/12/20
 * @Desc MybatisPlusConfig 配置
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.youxuan.goods.center.mapper")
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
