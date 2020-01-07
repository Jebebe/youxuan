package com.youxuan.goods.center.controller;

import com.youxuan.common.utils.result.PageResult;
import com.youxuan.common.utils.result.Result;
import com.youxuan.common.utils.result.ResultUtils;
import com.youxuan.goods.center.api.param.BrandAddParamDTO;
import com.youxuan.goods.center.api.param.BrandDeleteParamDTO;
import com.youxuan.goods.center.api.param.BrandUpdateParamDTO;
import com.youxuan.goods.center.api.result.BrandListResultDTO;
import com.youxuan.goods.center.api.param.BrandSearchParamDTO;
import com.youxuan.goods.center.entity.Brand;
import com.youxuan.goods.center.service.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/brand/")
@Api(value = "BrandController", description = "品牌相关控制器")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("getAllBrand")
    @ApiOperation(value = "获取所有品牌", notes = "不分页")
    public Result<List<BrandListResultDTO>> getAllBrand() {

        List<BrandListResultDTO> allBrand = brandService.getAllBrand();
        return ResultUtils.successResult(allBrand);
    }

    @PostMapping("getBrandPageList")
    @ApiOperation(value = "品牌分页列表")
    public Result<PageResult<BrandListResultDTO>> getBrandPageList(@RequestBody BrandSearchParamDTO brandParamDTO) {

        return brandService.getBrandPageList(brandParamDTO);
    }

    @PostMapping("add")
    @ApiOperation(value = "新增品牌")
    public Result<Boolean> add(@RequestBody BrandAddParamDTO brandAdd) {

        return brandService.add(brandAdd);
    }

    @PostMapping("update")
    @ApiOperation(value = "品牌更新")
    public Result<Boolean> update(@RequestBody BrandUpdateParamDTO update) {

        return brandService.update(update);
    }

    @PostMapping("delete")
    @ApiOperation(value = "品牌批量删除")
    public Result<Boolean> delete(@RequestBody BrandDeleteParamDTO delete) {

        return brandService.delete(delete);
    }

    @GetMapping("details")
    @ApiOperation(value = "获取品牌详情")
    public Result<BrandListResultDTO> details(@RequestParam(value = "id") Long id) {
        return brandService.details(id);
    }
}
