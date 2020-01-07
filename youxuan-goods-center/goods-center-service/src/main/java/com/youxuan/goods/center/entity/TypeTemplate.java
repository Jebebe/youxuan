package com.youxuan.goods.center.entity;

import com.youxuan.common.utils.bean.Entity;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "类型模板实体对象")
@Accessors(chain = true)
public class TypeTemplate extends Entity {

    private static final long serialVersionUID = 1L;
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 类目名称
     */
    private String categoryName;

    /**
     * 关联规格
     */
    private String specIds;

    /**
     * 关联品牌
     */
    private String brandIds;

    /**
     * 自定义属性
     */
    private String customAttributeItems;

    /**
     * 状态（1：有效 2：封禁）
     */
    private Integer status;

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
        TypeTemplate other = (TypeTemplate) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCategoryName() == null ? other.getCategoryName() == null : this.getCategoryName().equals(other.getCategoryName()))
            && (this.getSpecIds() == null ? other.getSpecIds() == null : this.getSpecIds().equals(other.getSpecIds()))
            && (this.getBrandIds() == null ? other.getBrandIds() == null : this.getBrandIds().equals(other.getBrandIds()))
            && (this.getCustomAttributeItems() == null ? other.getCustomAttributeItems() == null : this.getCustomAttributeItems().equals(other.getCustomAttributeItems()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
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
        result = prime * result + ((getCategoryName() == null) ? 0 : getCategoryName().hashCode());
        result = prime * result + ((getSpecIds() == null) ? 0 : getSpecIds().hashCode());
        result = prime * result + ((getBrandIds() == null) ? 0 : getBrandIds().hashCode());
        result = prime * result + ((getCustomAttributeItems() == null) ? 0 : getCustomAttributeItems().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getUpdatedTime() == null) ? 0 : getUpdatedTime().hashCode());
        result = prime * result + ((getCreatedBy() == null) ? 0 : getCreatedBy().hashCode());
        result = prime * result + ((getUpdatedBy() == null) ? 0 : getUpdatedBy().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        return result;
    }

}