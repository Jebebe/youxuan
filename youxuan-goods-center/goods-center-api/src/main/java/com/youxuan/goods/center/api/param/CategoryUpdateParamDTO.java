package com.youxuan.goods.center.api.param;

import lombok.Data;

/**
 * @Author: jebe
 * @Date: 2019/12/24 16:55
 * @Desc 类目修改入参对象
 */
@Data
public class CategoryUpdateParamDTO {

    /**
     * 类目ID
     */
    private Long id;

    /**
     * 父类目ID=0时，代表的是一级的类目
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
