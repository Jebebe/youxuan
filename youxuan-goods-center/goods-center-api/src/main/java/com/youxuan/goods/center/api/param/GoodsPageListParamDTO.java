package com.youxuan.goods.center.api.param;

import lombok.Data;
import java.io.Serializable;

/**
 * @Author: jebe
 * @Date: 2019/12/20 19:37
 * @Desc 商品列表入参对象
 */
@Data
public class GoodsPageListParamDTO implements Serializable {

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 当前页
     */
    private long currentPage;

    /**
     * 当前页多少条
     */
    private long pageSize;
}
