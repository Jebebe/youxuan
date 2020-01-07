package com.youxuan.goods.center.api.result;

import lombok.Data;

/**
 * @Author: jebe
 * @Date: 2019/12/18 21:51
 * @Desc 品牌结果对象
 */
@Data
public class BrandListResultDTO {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 品牌名称
     */
    private String name;

    /**
     * 品牌首字母
     */
    private String firstChar;
}
