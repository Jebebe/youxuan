package com.youxuan.goods.center.mapper;

import com.youxuan.common.utils.mapper.BaseMapper;
import com.youxuan.common.utils.result.Result;
import com.youxuan.goods.center.api.param.CategoryDeleteParamDTO;
import com.youxuan.goods.center.api.result.CategoryListResultDTO;
import com.youxuan.goods.center.api.result.CategoryResultDTO;
import com.youxuan.goods.center.entity.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper extends BaseMapper<Category, Long> {

    /**
     * 查询类目列表
     * @return List<Category>
     */
    List<CategoryListResultDTO > selectCategoryList();

    /**
     * 类目批量删除
     * @param categoryIds
     * @return int
     */
    int batchDelete(@Param("categoryIds") List<Long> categoryIds , @Param("updatedBy") Long updatedBy);

}