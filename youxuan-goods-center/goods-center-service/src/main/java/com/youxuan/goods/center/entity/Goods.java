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
 * @Desc SPU实体对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "SPU实体对象")
@Accessors(chain = true)
public class Goods extends Entity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 商家ID
     */
    private String sellerId;

    /**
     * SPU名
     */
    private String goodsName;

    /**
     * 0:未审核 1:已审核 2:审核未通过 3:已关闭
     */
    private Integer status;

    /**
     * 是否上架（1：是 0：否）
     */
    private Integer isShelves;

    /**
     * 品牌ID
     */
    private Long brandId;

    /**
     * 副标题
     */
    private String subTitle;

    /**
     * 一级类目
     */
    private Long category1Id;

    /**
     * 二级类目
     */
    private Long category2Id;

    /**
     * 三级类目
     */
    private Long category3Id;

    /**
     * 小图
     */
    private String smallPic;

    /**
     * 商城价
     */
    private BigDecimal price;

    /**
     * 分类模板ID
     */
    private Long typeTemplateId;

    /**
     * 是否启用规格(0：未启用  1：启用)
     */
    private Boolean isEnableSpec;

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
        Goods other = (Goods) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSellerId() == null ? other.getSellerId() == null : this.getSellerId().equals(other.getSellerId()))
            && (this.getGoodsName() == null ? other.getGoodsName() == null : this.getGoodsName().equals(other.getGoodsName()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getIsShelves() == null ? other.getIsShelves() == null : this.getIsShelves().equals(other.getIsShelves()))
            && (this.getBrandId() == null ? other.getBrandId() == null : this.getBrandId().equals(other.getBrandId()))
            && (this.getSubTitle() == null ? other.getSubTitle() == null : this.getSubTitle().equals(other.getSubTitle()))
            && (this.getCategory1Id() == null ? other.getCategory1Id() == null : this.getCategory1Id().equals(other.getCategory1Id()))
            && (this.getCategory2Id() == null ? other.getCategory2Id() == null : this.getCategory2Id().equals(other.getCategory2Id()))
            && (this.getCategory3Id() == null ? other.getCategory3Id() == null : this.getCategory3Id().equals(other.getCategory3Id()))
            && (this.getSmallPic() == null ? other.getSmallPic() == null : this.getSmallPic().equals(other.getSmallPic()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getTypeTemplateId() == null ? other.getTypeTemplateId() == null : this.getTypeTemplateId().equals(other.getTypeTemplateId()))
            && (this.getIsEnableSpec() == null ? other.getIsEnableSpec() == null : this.getIsEnableSpec().equals(other.getIsEnableSpec()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getUpdatedTime() == null ? other.getUpdatedTime() == null : this.getUpdatedTime().equals(other.getUpdatedTime()))
            && (this.getCreatedBy() == null ? other.getCreatedBy() == null : this.getCreatedBy().equals(other.getCreatedBy()))
            && (this.getUpdatedBy() == null ? other.getUpdatedBy() == null : this.getUpdatedBy().equals(other.getUpdatedBy()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSellerId() == null) ? 0 : getSellerId().hashCode());
        result = prime * result + ((getGoodsName() == null) ? 0 : getGoodsName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getIsShelves() == null) ? 0 : getIsShelves().hashCode());
        result = prime * result + ((getBrandId() == null) ? 0 : getBrandId().hashCode());
        result = prime * result + ((getSubTitle() == null) ? 0 : getSubTitle().hashCode());
        result = prime * result + ((getCategory1Id() == null) ? 0 : getCategory1Id().hashCode());
        result = prime * result + ((getCategory2Id() == null) ? 0 : getCategory2Id().hashCode());
        result = prime * result + ((getCategory3Id() == null) ? 0 : getCategory3Id().hashCode());
        result = prime * result + ((getSmallPic() == null) ? 0 : getSmallPic().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getTypeTemplateId() == null) ? 0 : getTypeTemplateId().hashCode());
        result = prime * result + ((getIsEnableSpec() == null) ? 0 : getIsEnableSpec().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getUpdatedTime() == null) ? 0 : getUpdatedTime().hashCode());
        result = prime * result + ((getCreatedBy() == null) ? 0 : getCreatedBy().hashCode());
        result = prime * result + ((getUpdatedBy() == null) ? 0 : getUpdatedBy().hashCode());
        return result;
    }

}