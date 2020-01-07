package com.youxuan.goods.service.service;

import com.youxuan.common.utils.result.Result;
import com.youxuan.goods.center.api.result.GoodsDetailsResultDTO;

/**
 * @Author: jebe
 * @Date: 2019/12/18 20:26
 */
public interface GoodsService {

    /**
     * 商品详情
     * @param goodsId SPU_ID
     * @return Result<GoodsDetailsResultDTO>
     */
    Result<GoodsDetailsResultDTO> getGoodsDetails(Long goodsId);

}
