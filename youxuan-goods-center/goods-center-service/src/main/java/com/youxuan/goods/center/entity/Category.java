package com.youxuan.goods.center.entity;

import com.youxuan.common.utils.bean.Entity;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author: Jebe
 * @Date: 2019/12/22
 * @Desc 类目实体对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "类目实体对象")
@Accessors(chain = true)
public class Category extends Entity {

    private static final long serialVersionUID = 1L;

    /**
     * 类目ID
     */
    private Long id;

    /**
     * 父类目ID=0时，代表的是一级的类目
     */
    private Long parentId;

    /**
     * 类目名称
     */
    private String name;

    /**
     * 类型模板ID
     */
    private Long typeTemplateId;

    /**
     * 状态（1：有效 2：封禁）
     */
    private Integer status;

    public Category(Long id, Long parentId, String name, Long typeTemplateId) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.typeTemplateId = typeTemplateId;
    }

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
        Category other = (Category) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getTypeTemplateId() == null ? other.getTypeTemplateId() == null : this.getTypeTemplateId().equals(other.getTypeTemplateId()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getUpdatedTime() == null ? other.getUpdatedTime() == null : this.getUpdatedTime().equals(other.getUpdatedTime()))
            && (this.getCreatedBy() == null ? other.getCreatedBy() == null : this.getCreatedBy().equals(other.getCreatedBy()))
            && (this.getUpdatedBy() == null ? other.getUpdatedBy() == null : this.getUpdatedBy().equals(other.getUpdatedBy()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getTypeTemplateId() == null) ? 0 : getTypeTemplateId().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getUpdatedTime() == null) ? 0 : getUpdatedTime().hashCode());
        result = prime * result + ((getCreatedBy() == null) ? 0 : getCreatedBy().hashCode());
        result = prime * result + ((getUpdatedBy() == null) ? 0 : getUpdatedBy().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        return result;
    }
}