package com.youxuan.goods.center.api.param;

import lombok.Data;

/**
 * @Author: jebe
 * @Date: 2019/12/24 15:47
 * @Desc 类目新增入参对象
 */
@Data
public class CategoryAddParamDTO {

    /**
     * 父类目ID
     */
    private Long parentId;

    /**
     * 类目名称
     */
    private String name;

    /**
     * 类型模板ID
     */
    private Long typeTemplateId;
}
