package com.youxuan.goods.center.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youxuan.common.utils.bean.BeanUtils;
import com.youxuan.common.utils.result.PageResult;
import com.youxuan.common.utils.result.Result;
import com.youxuan.common.utils.result.ResultUtils;
import com.youxuan.goods.center.api.param.GoodsPageListParamDTO;
import com.youxuan.goods.center.api.result.*;
import com.youxuan.goods.center.entity.Goods;
import com.youxuan.goods.center.entity.GoodsDesc;
import com.youxuan.goods.center.entity.Item;
import com.youxuan.goods.center.mapper.GoodsDescMapper;
import com.youxuan.goods.center.mapper.GoodsMapper;
import com.youxuan.goods.center.mapper.ItemMapper;
import com.youxuan.goods.center.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: jebe
 * @Date: 2019/12/25 15:22
 * @Desc TODO
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private GoodsDescMapper goodsDescMapper;

    @Override
    public Result<PageResult<GoodsPageListResultDTO>> getGoodsPageList(GoodsPageListParamDTO listParam) {

        Page<Goods> page = new Page<>();
        page.setCurrent(listParam.getCurrentPage());
        page.setSize(listParam.getPageSize());
        IPage<Goods> goodsIPage = goodsMapper.selectGoodsPageList(page, listParam);
        List<GoodsPageListResultDTO> goodsPageList = BeanUtils.mapList(goodsIPage.getRecords(), GoodsPageListResultDTO.class);
        return ResultUtils.successPageResult(goodsIPage.getTotal(), goodsIPage.getCurrent(), goodsIPage.getSize(), goodsIPage.getSize(), goodsPageList);
    }

    @Override
    public Result<List<Item>> getAllItemList() {

        List<Item> itemList = itemMapper.selectAllItemList();
        return ResultUtils.successResult(itemList);
    }

    @Override
    public Result<GoodsDetailsResultDTO> getGoodsDetails(Long goodsId) {

        GoodsDetailsResultDTO detailsResult = new GoodsDetailsResultDTO();
        GoodsDetailsDTO goods = goodsMapper.selectGoodsAndCategory(goodsId);
        List<ItemDetailsDTO> itemList = itemMapper.selectItemByGoodsId(goodsId);
        GoodsDesc goodsDesc = goodsDescMapper.selectByPrimaryKey(goodsId);
        detailsResult.setGoods(goods);
        detailsResult.setItemList(itemList);
        detailsResult.setGoodsDesc(BeanUtils.map(goodsDesc, GoodsDescResultDTO.class));
        return ResultUtils.successResult(detailsResult);
    }
}
