package com.youxuan.goods.center.api.result;

import lombok.Data;
import java.io.Serializable;

/**
 * @Author: jebe
 * @Date: 2019/12/23 16:11
 * @Desc 类目实体对象
 */
@Data
public class CategoryResultDTO implements Serializable {

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
