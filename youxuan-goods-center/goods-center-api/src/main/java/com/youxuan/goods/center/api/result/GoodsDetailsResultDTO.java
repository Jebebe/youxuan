package com.youxuan.goods.center.api.result;

import lombok.Data;
import java.util.List;

/**
 * @Author: jebe
 * @Date: 2020/1/6 14:21
 * @Desc 商品详情结果对象
 */
@Data
public class GoodsDetailsResultDTO {

    /**
     * SPU信息
     */
    private GoodsDetailsDTO goods;

    /**
     * SPU描述信息
     */
    private GoodsDescResultDTO goodsDesc;

    /**
     * SKU列表
     */
    private List<ItemDetailsDTO> itemList;

    /**
     * 配送地址
     */
    private String address = "北京市 朝阳区 大道路口 12大街";

    /**
     * 评论数
     */
    private Integer commentCount = 100000;

}
