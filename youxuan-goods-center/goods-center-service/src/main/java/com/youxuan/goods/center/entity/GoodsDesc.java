package com.youxuan.goods.center.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author: Jebe
 * @Date: 2019/12/22
 * @Desc SPU描述信息实体对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "SPU描述信息实体对象")
@Accessors(chain = true)
public class GoodsDesc implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * SPU_ID
     */
    private Long goodsId;

    /**
     * 描述
     */
    private String introductions;

    /**
     * 规格结果集，所有规格，包含isSelected
     */
    private String specificationItems;

    /**
     * 自定义属性（参数结果）
     */
    private String customAttributesItems;

    /**
     * 商品图片
     */
    private String itemImages;

    /**
     * 包装列表
     */
    private String packages;

    /**
     * 售后服务
     */
    private String saleService;

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
        GoodsDesc other = (GoodsDesc) that;
        return (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getIntroductions() == null ? other.getIntroductions() == null : this.getIntroductions().equals(other.getIntroductions()))
            && (this.getSpecificationItems() == null ? other.getSpecificationItems() == null : this.getSpecificationItems().equals(other.getSpecificationItems()))
            && (this.getCustomAttributesItems() == null ? other.getCustomAttributesItems() == null : this.getCustomAttributesItems().equals(other.getCustomAttributesItems()))
            && (this.getItemImages() == null ? other.getItemImages() == null : this.getItemImages().equals(other.getItemImages()))
            && (this.getPackages() == null ? other.getPackages() == null : this.getPackages().equals(other.getPackages()))
            && (this.getSaleService() == null ? other.getSaleService() == null : this.getSaleService().equals(other.getSaleService()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getIntroductions() == null) ? 0 : getIntroductions().hashCode());
        result = prime * result + ((getSpecificationItems() == null) ? 0 : getSpecificationItems().hashCode());
        result = prime * result + ((getCustomAttributesItems() == null) ? 0 : getCustomAttributesItems().hashCode());
        result = prime * result + ((getItemImages() == null) ? 0 : getItemImages().hashCode());
        result = prime * result + ((getPackages() == null) ? 0 : getPackages().hashCode());
        result = prime * result + ((getSaleService() == null) ? 0 : getSaleService().hashCode());
        return result;
    }

}