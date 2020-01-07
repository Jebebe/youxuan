package com.youxuan.goods.center.api.result;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: jebe
 * @Date: 2020/1/6 16:22
 * @Desc 商品详情Item列表实体对象
 */
@Data
public class ItemDetailsDTO {

    /**
     * SKU_ID
     */
    private Long itemId;

    /**
     * SKU_title
     */
    private String title;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 商品规格
     */
    private String specNames;

}
