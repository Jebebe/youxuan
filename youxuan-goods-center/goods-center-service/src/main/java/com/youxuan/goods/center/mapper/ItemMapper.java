package com.youxuan.goods.center.mapper;

import com.youxuan.common.utils.mapper.BaseMapper;
import com.youxuan.goods.center.api.result.ItemDetailsDTO;
import com.youxuan.goods.center.entity.Item;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemMapper extends BaseMapper<Item, Long> {

    List<Item> selectAllItemList();

    /**
     * 根据Goods查询Item
     * @param goodsId
     * @return List<GoodsDetailsDTO>
     */
    List<ItemDetailsDTO> selectItemByGoodsId(@Param(value = "goodsId") Long goodsId);
}