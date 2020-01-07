package com.youxuan.search.service.feign;

import com.youxuan.common.utils.result.PageResult;
import com.youxuan.common.utils.result.Result;
import com.youxuan.goods.center.entity.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Author: jebe
 * @Date: 2019/12/29 10:42
 * @Desc 商品中心调用接口
 */
@FeignClient("YOUXUAN-GOODS-CENTER")
public interface GoodsCenterService {

    @GetMapping("/goods/getAllItemList")
    Result<List<Item>> getAllItemList();
}
