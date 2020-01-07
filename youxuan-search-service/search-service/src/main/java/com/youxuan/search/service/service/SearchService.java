package com.youxuan.search.service.service;

import com.youxuan.common.utils.result.Result;
import com.youxuan.search.api.result.ItemSearchResultDTO;

import java.util.List;

/**
 * @Author: jebe
 * @Date: 2019/12/29 15:18
 * @Desc TODO
 */
public interface SearchService {

    /**
     * 商品搜索
     * @param keyword   关键字
     * @param category  类目
     * @param brand     品牌
     * @param spec      规格
     * @param price     价格
     * @param sort      排序(要排序的字段：排序方式【ASC/DESC】)
     * @param currentPage   当前页
     * @param pageSize      每页条数
     * @return Result<ItemSearchResultDTO>
     */
    Result<ItemSearchResultDTO> search(String keyword, String category, String brand, String spec,
                                       String price, String sort, long currentPage, long pageSize);

    /**
     * 搜索建议
     * @param keyword
     * @return Result<List<String>>
     */
    Result<List<String>> suggest(String keyword);
}
