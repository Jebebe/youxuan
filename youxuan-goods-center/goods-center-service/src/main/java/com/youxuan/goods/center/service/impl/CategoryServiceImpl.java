package com.youxuan.goods.center.service.impl;

import com.youxuan.common.utils.bean.BeanUtils;
import com.youxuan.common.utils.result.Result;
import com.youxuan.common.utils.result.ResultUtils;
import com.youxuan.goods.center.api.param.CategoryAddParamDTO;
import com.youxuan.goods.center.api.param.CategoryDeleteParamDTO;
import com.youxuan.goods.center.api.param.CategoryUpdateParamDTO;
import com.youxuan.goods.center.api.result.CategoryListResultDTO;
import com.youxuan.goods.center.api.result.CategoryResultDTO;
import com.youxuan.goods.center.entity.Category;
import com.youxuan.goods.center.mapper.CategoryMapper;
import com.youxuan.goods.center.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author: jebe
 * @Date: 2019/12/23 16:16
 * @Desc TODO
 */
@Slf4j
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Result<List<CategoryListResultDTO>> getAllCategoryList() {
        StopWatch watch = new StopWatch("获取类目列表");
        watch.start("===开始===");
        List<CategoryListResultDTO> allCategoryList = categoryMapper.selectCategoryList();
        // 一级类目
        List<CategoryListResultDTO> parentList = allCategoryList.stream().filter(category -> category.getParentId() == 0).collect(Collectors.toList());
        List<CategoryListResultDTO> list = new ArrayList<>(parentList.size());
        parentList.forEach(parent -> {
            // 二级类目
            List<CategoryListResultDTO> childList = allCategoryList.stream().filter(category -> category.getParentId().equals(parent.getId())).collect(Collectors.toList());
            parent.setList(childList);
            childList.forEach(child -> {
                // 三级类目
                List<CategoryListResultDTO> thirdList = allCategoryList.stream().filter(category -> category.getParentId().equals(child.getId())).collect(Collectors.toList());
                child.setList(thirdList);
            });
            list.add(parent);
        });
        watch.stop();
        log.info(watch.prettyPrint());
        return ResultUtils.successResult(list);
    }

    @Override
    public Result<Boolean> add(CategoryAddParamDTO addParam) {
        Category category = BeanUtils.map(addParam, Category.class);
        category.setStatus(1).setCreatedTime(LocalDateTime.now()).setCreatedBy(1L).setIsDeleted(false);
        if (Objects.isNull(category.getParentId())) {
            category.setParentId(0L);
        }
        int result = categoryMapper.insert(category);
        return ResultUtils.successResult(result > 0);
    }

    @Override
    public Result<Boolean> update(CategoryUpdateParamDTO updateParam) {
        Category category = BeanUtils.map(updateParam, Category.class);
        category.setUpdatedTime(LocalDateTime.now()).setUpdatedBy(1L);
        int result = categoryMapper.updateByPrimaryKeySelective(category);
        return ResultUtils.successResult(result > 0);
    }

    @Override
    public Result<Boolean> delete(CategoryDeleteParamDTO deleteParam) {
        Long updatedBy = 1L;
        int result = categoryMapper.batchDelete(deleteParam.getCategoryIds(), updatedBy);
        return ResultUtils.successResult(result > 0);
    }

    @Override
    public Result<CategoryResultDTO> details(Long id) {
        Category category = categoryMapper.selectByPrimaryKey(id);
        CategoryResultDTO categoryDTO = BeanUtils.map(category, CategoryResultDTO.class);
        return ResultUtils.successResult(categoryDTO);
    }
}
