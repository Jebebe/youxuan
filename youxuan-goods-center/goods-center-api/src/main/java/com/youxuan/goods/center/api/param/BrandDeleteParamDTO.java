package com.youxuan.goods.center.api.param;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: jebe
 * @Date: 2019/12/21 13:58
 * @Desc 品牌删除入参对象
 */
@Data
public class BrandDeleteParamDTO implements Serializable {

    /**
     * 品牌ID数组
     */
    private List<Long> ids;

}
