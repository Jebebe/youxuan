package com.youxuan.goods.center.util;

import com.alibaba.fastjson.JSON;
import com.youxuan.common.utils.redis.RedisUtils;
import com.youxuan.goods.center.api.result.CategoryListResultDTO;
import com.youxuan.goods.center.entity.SpecificationOption;
import com.youxuan.goods.center.entity.TypeTemplate;
import com.youxuan.goods.center.mapper.CategoryMapper;
import com.youxuan.goods.center.mapper.SpecificationOptionMapper;
import com.youxuan.goods.center.mapper.TypeTemplateMapper;
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
import java.util.Map;

@SpringBootConfiguration
// @EnableAutoConfiguration
// @EnableEurekaClient
// @EnableDiscoveryClient
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CategoryAndBrandToRedisApplication.class)
@MapperScan("com.youxuan.goods.center.mapper")
@ComponentScan(basePackages = {"com.youxuan.goods.center", "com.youxuan.common.utils.redis"})
public class CategoryAndBrandToRedisApplication {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private TypeTemplateMapper templateMapper;
    @Autowired
    private SpecificationOptionMapper optionMapper;
    @Autowired
    private RedisUtils redisUtils;

    @Test
    public void categoryImportRedis() {
		List<CategoryListResultDTO> categoryList = categoryMapper.selectCategoryList();
		categoryList.forEach(category -> {
			boolean cateInfo = redisUtils.hset("cateInfo", category.getName(), category.getTypeTemplateId());
		});
    }

    @Test
    public void brandAndSpecImportToRedis() {
        List<TypeTemplate> tempList = templateMapper.selectTypeTempList();
        tempList.forEach(temp -> {
            //查询品牌列表
            List<Map> brandList = JSON.parseArray(temp.getBrandIds(), Map.class);
            boolean brandResult = redisUtils.hset("brandList", String.valueOf(temp.getId()), brandList);

            List<Map> specList = JSON.parseArray(temp.getSpecIds(), Map.class);
            for (Map map : specList) {
                List<SpecificationOption> options = optionMapper.selectSpecOptionsBySpecId(Long.valueOf((Integer) map.get("id")));
                map.put("options", options);
            }
            boolean result = redisUtils.hset("specList", String.valueOf(temp.getId()), specList);
        });
    }

}
