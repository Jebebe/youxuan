package com.youxuan.goods.service.service.impl;

import com.youxuan.common.utils.result.Result;
import com.youxuan.goods.center.api.result.GoodsDetailsResultDTO;
import com.youxuan.goods.service.feign.GoodsCenterService;
import com.youxuan.goods.service.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: jebe
 * @Date: 2019/12/18 20:28
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsCenterService goodsCenterService;

    @Override
    public Result<GoodsDetailsResultDTO> getGoodsDetails(Long goodsId) {

        return goodsCenterService.getGoodsDetails(goodsId);
    }
}
