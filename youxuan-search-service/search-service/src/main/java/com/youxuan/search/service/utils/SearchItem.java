package com.youxuan.search.service.utils;

import lombok.Data;

/**
 * @Author: jebe
 * @Date: 2019/12/29 14:31
 * @Desc ES搜索字段映射
 */
@Data
public class SearchItem {

    /**
     * 商品ID
     */
    private Long itemId;

    /**
     * SPU_ID
     */
    private Long goodsId;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 商品价格
     */
    private Double price;

    /**
     * 类目名称
     */
    private String category;

    /**
     * 商家名称
     */
    private String seller;

    /**
     * 品牌名称
     */
    private String brand;
}
