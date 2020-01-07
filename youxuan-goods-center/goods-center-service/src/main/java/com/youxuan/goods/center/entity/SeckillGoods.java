package com.youxuan.goods.center.entity;


import com.youxuan.common.utils.bean.Entity;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author: Jebe
 * @Date: 2019/12/22
 * @Desc 秒杀商品实体对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "秒杀商品实体对象")
@Accessors(chain = true)
public class SeckillGoods extends Entity {

    private static final long serialVersionUID = 1L;
    /**
     * 主键ID
     */
    private Long id;

    /**
     * spu ID
     */
    private Long goodsId;

    /**
     * sku ID
     */
    private Long itemId;

    /**
     * 标题
     */
    private String title;

    /**
     * 商品图片
     */
    private String smallPic;

    /**
     * 原价格
     */
    private BigDecimal price;

    /**
     * 秒杀价格
     */
    private BigDecimal costPrice;

    /**
     * 商家ID
     */
    private String sellerId;

    /**
     * 审核日期
     */
    private LocalDateTime checkedTime;

    /**
     * 审核状态（1：待审核 2：审核通过  3：审核不通过 4：下架）
     */
    private String status;

    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    /**
     * 秒杀商品数
     */
    private Integer num;

    /**
     * 剩余库存数
     */
    private Integer stockCount;

    /**
     * 描述
     */
    private String introduction;

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
        SeckillGoods other = (SeckillGoods) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getSmallPic() == null ? other.getSmallPic() == null : this.getSmallPic().equals(other.getSmallPic()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getCostPrice() == null ? other.getCostPrice() == null : this.getCostPrice().equals(other.getCostPrice()))
            && (this.getSellerId() == null ? other.getSellerId() == null : this.getSellerId().equals(other.getSellerId()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getCheckedTime() == null ? other.getCheckedTime() == null : this.getCheckedTime().equals(other.getCheckedTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
            && (this.getStockCount() == null ? other.getStockCount() == null : this.getStockCount().equals(other.getStockCount()))
            && (this.getIntroduction() == null ? other.getIntroduction() == null : this.getIntroduction().equals(other.getIntroduction()))
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
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getSmallPic() == null) ? 0 : getSmallPic().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getCostPrice() == null) ? 0 : getCostPrice().hashCode());
        result = prime * result + ((getSellerId() == null) ? 0 : getSellerId().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getCheckedTime() == null) ? 0 : getCheckedTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        result = prime * result + ((getStockCount() == null) ? 0 : getStockCount().hashCode());
        result = prime * result + ((getIntroduction() == null) ? 0 : getIntroduction().hashCode());
        result = prime * result + ((getUpdatedTime() == null) ? 0 : getUpdatedTime().hashCode());
        result = prime * result + ((getCreatedBy() == null) ? 0 : getCreatedBy().hashCode());
        result = prime * result + ((getUpdatedBy() == null) ? 0 : getUpdatedBy().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        return result;
    }

}