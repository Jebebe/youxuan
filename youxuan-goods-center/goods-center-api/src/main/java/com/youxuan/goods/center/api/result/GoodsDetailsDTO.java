package com.youxuan.goods.center.api.result;

import lombok.Data;

/**
 * @Author: jebe
 * @Date: 2020/1/6 17:31
 * @Desc TODO
 */
@Data
public class GoodsDetailsDTO {

    /**
     * SPU_ID
     */
    private Long goodsId;

    /**
     * SPU名称
     */
    private String goodsName;

    /**
     * 副标题
     */
    private String subTitle;

    /**
     * 一级类目名称
     */
    private String category1Name;

    /**
     * 二级类目名称
     */
    private String category2Name;

    /**
     * 三级类目名称
     */
    private String category3Name;

}
