package com.youxuan.goods.center.entity;

import com.youxuan.common.utils.bean.Entity;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.math.BigDecimal;

/**
 * @Author: Jebe
 * @Date: 2019/12/22
 * @Desc SKU实体对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "SKU实体对象")
@Accessors(chain = true)
public class Item extends Entity {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id，同时也是商品编号
     */
    private Long id;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 商品卖点
     */
    private String sellPoint;

    /**
     * 商品价格，单位为：元
     */
    private BigDecimal price;

    /**
     * 库存盘点
     */
    private Integer stockCount;

    /**
     * 库存数量
     */
    private Integer num;

    /**
     * 商品条形码
     */
    private String barCode;

    /**
     * 商品图片
     */
    private String imageUrl;

    /**
     * 三级类目ID
     */
    private Long categoryId;

    /**
     * 类目名称
     */
    private String categoryName;

    /**
     * 商品状态，1-正常，2-下架，3-删除
     */
    private Integer status;

    private String itemSn;

    /**
     * 成本价格
     */
    private BigDecimal costPrice;

    /**
     * 市场价
     */
    private BigDecimal marketPrice;

    /**
     * 是否默认（1：是 0：否）
     */
    private Boolean isDefault;

    /**
     * SPU ID
     */
    private Long goodsId;

    /**
     * 商家ID
     */
    private String sellerId;

    /**
     * 购物车缩略图
     */
    private String cartThumbnailUrl;

    /**
     * 品牌
     */
    private String brandName;

    /**
     * 规格
     */
    private String specNames;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Item other = (Item) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getSellPoint() == null ? other.getSellPoint() == null : this.getSellPoint().equals(other.getSellPoint()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getStockCount() == null ? other.getStockCount() == null : this.getStockCount().equals(other.getStockCount()))
            && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
            && (this.getBarCode() == null ? other.getBarCode() == null : this.getBarCode().equals(other.getBarCode()))
            && (this.getImageUrl() == null ? other.getImageUrl() == null : this.getImageUrl().equals(other.getImageUrl()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getCategoryName() == null ? other.getCategoryName() == null : this.getCategoryName().equals(other.getCategoryName()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getItemSn() == null ? other.getItemSn() == null : this.getItemSn().equals(other.getItemSn()))
            && (this.getCostPrice() == null ? other.getCostPrice() == null : this.getCostPrice().equals(other.getCostPrice()))
            && (this.getMarketPrice() == null ? other.getMarketPrice() == null : this.getMarketPrice().equals(other.getMarketPrice()))
            && (this.getIsDefault() == null ? other.getIsDefault() == null : this.getIsDefault().equals(other.getIsDefault()))
            && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getSellerId() == null ? other.getSellerId() == null : this.getSellerId().equals(other.getSellerId()))
            && (this.getCartThumbnailUrl() == null ? other.getCartThumbnailUrl() == null : this.getCartThumbnailUrl().equals(other.getCartThumbnailUrl()))
            && (this.getBrandName() == null ? other.getBrandName() == null : this.getBrandName().equals(other.getBrandName()))
            && (this.getSpecNames() == null ? other.getSpecNames() == null : this.getSpecNames().equals(other.getSpecNames()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getUpdatedTime() == null ? other.getUpdatedTime() == null : this.getUpdatedTime().equals(other.getUpdatedTime()))
            && (this.getCreatedBy() == null ? other.getCreatedBy() == null : this.getCreatedBy().equals(other.getCreatedBy()))
            && (this.getUpdatedBy() == null ? other.getUpdatedBy() == null : this.getUpdatedBy().equals(other.getUpdatedBy()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getSellPoint() == null) ? 0 : getSellPoint().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getStockCount() == null) ? 0 : getStockCount().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        result = prime * result + ((getBarCode() == null) ? 0 : getBarCode().hashCode());
        result = prime * result + ((getImageUrl() == null) ? 0 : getImageUrl().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getCategoryName() == null) ? 0 : getCategoryName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getItemSn() == null) ? 0 : getItemSn().hashCode());
        result = prime * result + ((getCostPrice() == null) ? 0 : getCostPrice().hashCode());
        result = prime * result + ((getMarketPrice() == null) ? 0 : getMarketPrice().hashCode());
        result = prime * result + ((getIsDefault() == null) ? 0 : getIsDefault().hashCode());
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getSellerId() == null) ? 0 : getSellerId().hashCode());
        result = prime * result + ((getCartThumbnailUrl() == null) ? 0 : getCartThumbnailUrl().hashCode());
        result = prime * result + ((getBrandName() == null) ? 0 : getBrandName().hashCode());
        result = prime * result + ((getSpecNames() == null) ? 0 : getSpecNames().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getUpdatedTime() == null) ? 0 : getUpdatedTime().hashCode());
        result = prime * result + ((getCreatedBy() == null) ? 0 : getCreatedBy().hashCode());
        result = prime * result + ((getUpdatedBy() == null) ? 0 : getUpdatedBy().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        return result;
    }

}