package com.youxuan.goods.service.feign;

import com.youxuan.common.utils.result.Result;
import com.youxuan.goods.center.api.result.GoodsDetailsResultDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: jebe
 * @Date: 2020/1/6 16:04
 * @Desc 商品中心服务接口
 */
@FeignClient("YOUXUAN-GOODS-CENTER")
public interface GoodsCenterService {

    /**
     * 获取商品信息
     * @param goodsId SPU_ID
     * @return Result<GoodsDetailsResultDTO>
     */
    @GetMapping("/goods/getGoodsDetails")
    Result<GoodsDetailsResultDTO> getGoodsDetails(@RequestParam(value = "goodsId") Long goodsId);
}
