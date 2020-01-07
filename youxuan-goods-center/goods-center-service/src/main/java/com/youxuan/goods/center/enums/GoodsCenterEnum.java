package com.youxuan.goods.center.enums;

import lombok.*;

/**
 * @Author: jebe
 * @Date: 2019/12/22 20:43
 * @Desc 用户类型枚举
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum GoodsCenterEnum {

    USER(0L, "普通用户"),
    ADMIN(1L,"管理员");

    private Long code;
    private String msg;
}
