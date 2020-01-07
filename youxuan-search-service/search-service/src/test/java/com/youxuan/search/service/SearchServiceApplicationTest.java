package com.youxuan.search.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: jebe
 * @Date: 2019/12/29 15:32
 * @Desc TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SearchServiceApplicationTest.class)
@ComponentScan(basePackages = {"com.youxuan.search.service"})
public class SearchServiceApplicationTest {

    @Test
    public void test() {
    }
}
