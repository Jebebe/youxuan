package com.youxuan.goods.service.controller;

import com.youxuan.common.utils.result.Result;
import com.youxuan.goods.center.api.result.GoodsDetailsResultDTO;
import com.youxuan.goods.service.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/goods/")
@Api(value = "GoodsController", description = "商品控制器")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("getGoodsDetails")
    @ApiOperation(value = "商品详情")
    public Result<GoodsDetailsResultDTO> getGoodsDetails(@RequestParam(value = "goodsId") Long goodsId) {

        return goodsService.getGoodsDetails(goodsId);
    }

}
