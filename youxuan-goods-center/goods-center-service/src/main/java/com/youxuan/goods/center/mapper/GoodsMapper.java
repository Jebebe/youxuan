package com.youxuan.goods.center.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youxuan.common.utils.mapper.BaseMapper;
import com.youxuan.goods.center.api.param.GoodsPageListParamDTO;
import com.youxuan.goods.center.api.result.GoodsDetailsDTO;
import com.youxuan.goods.center.entity.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsMapper extends BaseMapper<Goods, Long> {
    /**
     * 商品分页列表
     * @param page
     * @param listParam
     * @return IPage<Goods>
     */
    IPage<Goods> selectGoodsPageList(@Param("page") Page<Goods> page, @Param("listParam") GoodsPageListParamDTO listParam);

    /**
     * 获取商品信息
     * @param goodsId
     * @return GoodsDetailsDTO
     */
    GoodsDetailsDTO selectGoodsAndCategory(@Param(value = "goodsId") Long goodsId);
}