package com.youxuan.goods.center.api.result;

import lombok.Data;

/**
 * @Author: jebe
 * @Date: 2020/1/6 16:37
 * @Desc 商品描述结果对象
 */
@Data
public class GoodsDescResultDTO {

    /**
     * SPU_ID
     */
    private Long goodsId;

    /**
     * 商品描述
     */
    private String introductions;

    /**
     * 包装结果集
     */
    private String packages;

    /**
     * 售后服务
     */
    private String saleService;

    /**
     * 图片列表
     */
    private String itemImages;

    /**
     * 自定义属性
     */
    private String customAttributesItems;

    /**
     * 规格结果集
     */
    private String specificationItems;

}
