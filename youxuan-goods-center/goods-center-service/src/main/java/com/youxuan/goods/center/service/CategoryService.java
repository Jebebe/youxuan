package com.youxuan.goods.center.service;

import com.youxuan.common.utils.result.Result;
import com.youxuan.goods.center.api.param.CategoryAddParamDTO;
import com.youxuan.goods.center.api.param.CategoryDeleteParamDTO;
import com.youxuan.goods.center.api.param.CategoryUpdateParamDTO;
import com.youxuan.goods.center.api.result.CategoryListResultDTO;
import com.youxuan.goods.center.api.result.CategoryResultDTO;

import java.util.List;

/**
 * @Author: jebe
 * @Date: 2019/12/23 16:07
 * @Desc TODO
 */
public interface CategoryService {

    /**
     * 获取类目列表
     * @return Result<List<CategoryResultDTO>>
     */
    Result<List<CategoryListResultDTO>> getAllCategoryList();

    /**
     * 新增类目
     * @param addParam
     * @return Result<Boolean>
     */
    Result<Boolean> add(CategoryAddParamDTO addParam);

    /**
     * 类目修改
     * @param updateParam
     * @return Result<Boolean>
     */
    Result<Boolean> update(CategoryUpdateParamDTO updateParam);

    /**
     * 类目批量删除
     * @param deleteParam
     * @return Result<Boolean>
     */
    Result<Boolean> delete(CategoryDeleteParamDTO deleteParam);

    /**
     * 获取类目详情
     * @param id
     * @return Result<Boolean>
     */
    Result<CategoryResultDTO> details(Long id);
}
