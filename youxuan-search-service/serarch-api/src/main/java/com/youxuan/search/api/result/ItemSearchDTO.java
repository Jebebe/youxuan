package com.youxuan.search.api.result;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: jebe
 * @Date: 2019/12/31 10:40
 * @Desc 商品结果
 */
@Data
public class ItemSearchDTO {

    /**
     * 商品ID
     */
    private Long itemId;

    /**
     * SPUID
     */
    private Long goodsId;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 商品类目
     */
    private String category;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 品牌
     */
    private String seller;

    /**
     * 商品图片
     */
    private String imageUrl;

}
