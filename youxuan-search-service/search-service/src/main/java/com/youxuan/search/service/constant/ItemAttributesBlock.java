package com.youxuan.search.service.constant;

import com.google.common.collect.ImmutableMap;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

/**
 * @Author: jebe
 * @Date: 2019/12/30 16:38
 * @Desc 商品属性区间定义
 */
@Data
@AllArgsConstructor
public class ItemAttributesBlock {

    private String key;
    private Integer max;
    private Integer min;

    /**
     * 价格区间定义
     */
    public static final Map<String, ItemAttributesBlock> PRICE_BLOCK;

    /**
     * 手机像素区间定义
     */
    public static final Map<String, ItemAttributesBlock> PIXEL_BLOCK;

    /**
     * 无限制区间
     */
    public static final ItemAttributesBlock ALL = new ItemAttributesBlock("*", -1, -1);

    static {
        PRICE_BLOCK = ImmutableMap.<String, ItemAttributesBlock>builder()
                .put("*-500", new ItemAttributesBlock("*-500", -1, 500))
                .put("500-1000", new ItemAttributesBlock("500-1000", 500, 1000))
                .put("1000-1500", new ItemAttributesBlock("1000-1500", 1000, 1500))
                .put("1500-2000", new ItemAttributesBlock("1500-2000", 1500, 2000))
                .put("2000-3000", new ItemAttributesBlock("2000-3000", 2000, 3000))
                .put("3000-*", new ItemAttributesBlock("3000-*", 3000, -1))
                .build();

        PIXEL_BLOCK = ImmutableMap.<String, ItemAttributesBlock>builder()
                .put("*-30", new ItemAttributesBlock("*-30", -1, 30))
                .put("30-50", new ItemAttributesBlock("30-50", 30, 50))
                .put("50-*", new ItemAttributesBlock("50-*", 50, -1))
                .build();
    }

    public static ItemAttributesBlock matchPrice(String key) {
        ItemAttributesBlock block = PRICE_BLOCK.get(key);
        if (block == null) {
            return ALL;
        }
        return block;
    }

    public static ItemAttributesBlock matchPixel(String key) {
        ItemAttributesBlock block = PIXEL_BLOCK.get(key);
        if (block == null) {
            return ALL;
        }
        return block;
    }

}
