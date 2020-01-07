package com.youxuan.search.api.result;

import com.youxuan.common.utils.result.PageResult;
import lombok.Data;
import java.util.List;
import java.util.Map;

/**
 * @Author: jebe
 * @Date: 2019/12/29 20:33
 * @Desc 商品搜索结果对象实体
 */
@Data
public class ItemSearchResultDTO {

    /**
     * 分页结果
     */
    private PageResult<ItemSearchDTO> pageResult;

    /**
     * 类目列表
     */
    private List<String> categoryList;

    /**
     * 品牌列表
     */
    private List<Map> brandList;

    /**
     * 规格列表
     */
    private List<Map> specList;
}
