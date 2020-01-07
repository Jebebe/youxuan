package com.youxuan.goods.center.api.param;

import lombok.Data;

import java.util.List;

/**
 * @Author: jebe
 * @Date: 2019/12/24 16:23
 * @Des 类目删除入参对象
 */
@Data
public class CategoryDeleteParamDTO {

    /**
     * 类目Id集合
     */
    private List<Long> categoryIds;
}
