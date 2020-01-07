package com.youxuan.goods.center.api.result;

import lombok.Data;
import java.io.Serializable;
import java.util.List;

/**
 * @Author: jebe
 * @Date: 2019/12/23 16:07
 * @Desc 类目列表结果对象
 */
@Data
public class CategoryListResultDTO implements Serializable {

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

    /**
     * 当前类目ID的子类目列表
     */
    private List<CategoryListResultDTO> list;

}
