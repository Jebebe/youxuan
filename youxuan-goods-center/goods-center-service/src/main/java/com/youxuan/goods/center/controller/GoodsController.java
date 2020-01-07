package com.youxuan.goods.center.controller;

import com.youxuan.common.utils.redis.RedisUtils;
import com.youxuan.common.utils.result.PageResult;
import com.youxuan.common.utils.result.Result;
import com.youxuan.goods.center.api.param.GoodsPageListParamDTO;
import com.youxuan.goods.center.api.result.GoodsDetailsResultDTO;
import com.youxuan.goods.center.api.result.GoodsPageListResultDTO;
import com.youxuan.goods.center.entity.Item;
import com.youxuan.goods.center.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: jebe
 * @Date: 2019/12/25 14:52
 * @Desc 商品控制器
 */
@Data
@CrossOrigin
@RestController
@RequestMapping("/goods/")
@Api(value = "GoodsController", description = "商品控制器")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping("getGoodsPageList")
    @ApiOperation(value = "商品分页列表")
    public Result<PageResult<GoodsPageListResultDTO>> getGoodsPageList(@RequestBody GoodsPageListParamDTO listParam) {

        return goodsService.getGoodsPageList(listParam);
    }

    @GetMapping("getAllItemList")
    @ApiOperation(value = "获取商品列表", notes = "[ES导入商品接口]")
    public Result<List<Item>> getAllItemList() {

        return goodsService.getAllItemList();
    }

    @GetMapping("getGoodsDetails")
    @ApiOperation(value = "获取商品详情", notes = "商品服务接口")
    public Result<GoodsDetailsResultDTO> getGoodsDetails(@RequestParam(value = "goodsId") Long goodsId) {

        return goodsService.getGoodsDetails(goodsId);
    }


}
