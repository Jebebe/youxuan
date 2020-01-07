package com.youxuan.common.utils.bean;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

/**
 * @Author: Jebe
 * @Date: 2019/12/21
 * @Desc Entity对象
 */
public class Entity {

    @ApiModelProperty("系统保留字段，记录数据创建时间")
    private LocalDateTime createdTime;

    @ApiModelProperty("系统保留字段，记录数据创建用户")
    private Long createdBy;

    @ApiModelProperty("系统保留字段，记录数据最后时间")
    private LocalDateTime updatedTime;

    @ApiModelProperty("系统保留字段，记录数据最后更新用户")
    private Long updatedBy;

    @ApiModelProperty("删除标记，1表示删除，0表示未删除")
    private Boolean isDeleted;

    public Entity() {
    }

    public LocalDateTime getCreatedTime() {
        return this.createdTime;
    }

    public Long getCreatedBy() {
        return this.createdBy;
    }

    public LocalDateTime getUpdatedTime() {
        return this.updatedTime;
    }

    public Long getUpdatedBy() {
        return this.updatedBy;
    }

    public Boolean getIsDeleted() {
        return this.isDeleted;
    }

    public Entity setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public Entity setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public Entity setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
        return this;
    }

    public Entity setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public Entity setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

}