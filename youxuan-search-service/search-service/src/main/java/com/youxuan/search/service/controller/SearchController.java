package com.youxuan.search.service.controller;

import com.youxuan.common.utils.result.Result;
import com.youxuan.search.api.result.ItemSearchResultDTO;
import com.youxuan.search.service.service.SearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: jebe
 * @Date: 2019/12/29 9:32
 * @Desc TODO
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/itemsearch/")
@Api(value = "SearchController", description = "搜索控制器")
public class SearchController {

    @Autowired
    private SearchService searchService;

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
    @GetMapping("search")
    @ApiOperation(value = "搜索入口")
    public Result<ItemSearchResultDTO> search(@RequestParam(value = "keyword") String keyword,
                                              @RequestParam(value = "category", required = false) String category,
                                              @RequestParam(value = "brand", required = false) String brand,
                                              @RequestParam(value = "spec", required = false) String spec,
                                              @RequestParam(value = "price", required = false) String price,
                                              @RequestParam(value = "sort", required = false) String sort,
                                              @RequestParam(value = "currentPage", defaultValue = "1L") long currentPage,
                                              @RequestParam(value = "pageSize", defaultValue = "40L") long pageSize) {

        return searchService.search(keyword, category, brand, spec, price, sort, currentPage, pageSize);
    }

    @GetMapping("suggest")
    @ApiOperation(value = "搜索建议")
    public Result<List<String>> suggest(@RequestParam(value = "keyword") String keyword) {

        return searchService.suggest(keyword);
    }

}
