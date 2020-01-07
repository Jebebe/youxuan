package com.youxuan.goods.center.service;

import com.youxuan.common.utils.result.PageResult;
import com.youxuan.common.utils.result.Result;
import com.youxuan.goods.center.api.param.GoodsPageListParamDTO;
import com.youxuan.goods.center.api.result.GoodsDetailsResultDTO;
import com.youxuan.goods.center.api.result.GoodsPageListResultDTO;
import com.youxuan.goods.center.entity.Item;

import java.util.List;

/**
 * @Author: jebe
 * @Date: 2019/12/25 14:55
 * @Desc TODO
 */
public interface GoodsService {

    /**
     * 商品分页列表
     * @param listParam
     * @return Result
     */
    Result<PageResult<GoodsPageListResultDTO>> getGoodsPageList(GoodsPageListParamDTO listParam);

    /**
     * 获取商品列表
     * @return Result<List<Item>>
     */
    Result<List<Item>> getAllItemList();

    /**
     * 获取商品详情
     * @param goodsId SPU_ID
     * @return Result<GoodsDetailsResultDTO>
     */
    Result<GoodsDetailsResultDTO> getGoodsDetails(Long goodsId);

}
