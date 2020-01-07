package com.youxuan.goods.center.api.param;

import lombok.Data;

/**
 * @Author: jebe
 * @Date: 2019/12/20 19:37
 * @Desc 品牌搜索入参对象
 */
@Data
public class BrandSearchParamDTO {

    /**
     * 品牌名称
     */
    private String name;

    /**
     * 品牌首字母
     */
    private String firstChar;

    /**
     * 当前页
     */
    private long currentPage;

    /**
     * 当前页多少条
     */
    private long pageSize;
}
