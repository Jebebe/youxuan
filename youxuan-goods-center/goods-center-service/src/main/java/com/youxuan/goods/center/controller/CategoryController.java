package com.youxuan.goods.center.controller;

import com.youxuan.common.utils.result.Result;
import com.youxuan.goods.center.api.param.CategoryAddParamDTO;
import com.youxuan.goods.center.api.param.CategoryDeleteParamDTO;
import com.youxuan.goods.center.api.param.CategoryUpdateParamDTO;
import com.youxuan.goods.center.api.result.CategoryListResultDTO;
import com.youxuan.goods.center.api.result.CategoryResultDTO;
import com.youxuan.goods.center.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: jebe
 * @Date: 2019/12/23 16:05
 * @Desc 商品类目控制器
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/category/")
@Api(value = "CategoryController", description = "商品类目控制器")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("getCategoryList")
    @ApiOperation(value = "获取类目列表")
    public Result<List<CategoryListResultDTO >> getCategoryList() {

        return categoryService.getAllCategoryList();
    }

    @PostMapping("add")
    @ApiOperation(value = "新增类目")
    public Result<Boolean> add(@RequestBody CategoryAddParamDTO addParam) {

        return categoryService.add(addParam);
    }

    @PostMapping("update")
    @ApiOperation(value = "类目修改")
    public Result<Boolean> update(@RequestBody CategoryUpdateParamDTO updateParam) {

        return categoryService.update(updateParam);
    }

    @PostMapping("delete")
    @ApiOperation(value = "类目删除")
    public Result<Boolean> delete(@RequestBody CategoryDeleteParamDTO deleteParam) {

        return categoryService.delete(deleteParam);
    }

    @GetMapping("details")
    @ApiOperation(value = "获取类目详情")
    public Result<CategoryResultDTO> details(@RequestParam(value = "id") Long id) {

        return categoryService.details(id);
    }


}
