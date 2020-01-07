package com.youxuan.goods.center.api.result;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: jebe
 * @Date: 2019/12/25 15:04
 * @Desc TODO
 */
@Data
public class GoodsPageListResultDTO implements Serializable {

    /**
     * 商品ID
     */
    private Long id;

    /**
     * SPU名
     */
    private String goodsName;

    /**
     * 商城价
     */
    private BigDecimal price;

    /**
     * 一级类目
     */
    private Long category1Id;

    /**
     * 二级类目
     */
    private Long category2Id;

    /**
     * 三级类目
     */
    private Long category3Id;

    /**
     * 0:未审核 1:已审核 2:审核未通过 3:已关闭
     */
    private Integer status;

}
