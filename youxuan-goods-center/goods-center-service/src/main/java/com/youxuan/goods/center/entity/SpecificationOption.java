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
 * @Desc 规格选项实体对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "规格选项实体对象")
@Accessors(chain = true)
public class SpecificationOption extends Entity {

    private static final long serialVersionUID = 1L;
    /**
     * 规格项ID
     */
    private Long id;

    /**
     * 规格项名称
     */
    private String optionName;

    /**
     * 规格ID
     */
    private Long specId;

    /**
     * 排序值
     */
    private Integer sort;

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
        SpecificationOption other = (SpecificationOption) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOptionName() == null ? other.getOptionName() == null : this.getOptionName().equals(other.getOptionName()))
            && (this.getSpecId() == null ? other.getSpecId() == null : this.getSpecId().equals(other.getSpecId()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getUpdatedTime() == null ? other.getUpdatedTime() == null : this.getUpdatedTime().equals(other.getUpdatedTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreatedBy() == null ? other.getCreatedBy() == null : this.getCreatedBy().equals(other.getCreatedBy()))
            && (this.getUpdatedBy() == null ? other.getUpdatedBy() == null : this.getUpdatedBy().equals(other.getUpdatedBy()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOptionName() == null) ? 0 : getOptionName().hashCode());
        result = prime * result + ((getSpecId() == null) ? 0 : getSpecId().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getUpdatedTime() == null) ? 0 : getUpdatedTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreatedBy() == null) ? 0 : getCreatedBy().hashCode());
        result = prime * result + ((getUpdatedBy() == null) ? 0 : getUpdatedBy().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        return result;
    }

}