package com.youxuan.common.utils.mapper;

import java.io.Serializable;

/**
 * Mapper公共基类
 *
 * @param <T> 泛型类
 * @param <L> The Primary Key Class 如果是无主键，则可以用Model来跳过，如果是多主键则是Key类
 */
public interface BaseMapper<T, L extends Serializable> {
    int deleteByPrimaryKey(L id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(L id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}