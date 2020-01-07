package com.youxuan.goods.center.api.param;

import lombok.Data;

/**
 * @Author: jebe
 * @Date: 2019/12/21 13:58
 * @Desc 品牌新增入参对象
 */
@Data
public class BrandAddParamDTO {

    /**
     * 品牌名称
     */
    private String name;

    /**
     * 品牌首字母
     */
    private String firstChar;
}
