package com.youxuan.search.service.service.impl;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.youxuan.common.utils.redis.RedisUtils;
import com.youxuan.common.utils.result.PageResult;
import com.youxuan.common.utils.result.Result;
import com.youxuan.common.utils.result.ResultUtils;
import com.youxuan.search.api.result.ItemSearchDTO;
import com.youxuan.search.api.result.ItemSearchResultDTO;
import com.youxuan.search.service.constant.ItemAttributesBlock;
import com.youxuan.search.service.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.search.suggest.Suggest;
import org.elasticsearch.search.suggest.SuggestBuilder;
import org.elasticsearch.search.suggest.SuggestBuilders;
import org.elasticsearch.search.suggest.completion.CompletionSuggestion;
import org.elasticsearch.search.suggest.completion.CompletionSuggestionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @Author: jebe
 * @Date: 2019/12/29 10:52
 * @Desc TODO
 */
@Slf4j
@Service("searchService")
public class SearchServiceImpl implements SearchService {

    @Value("${es.index}")
    private String esIndex;
    @Value("${es.type}")
    private String esType;

    @Autowired
    private TransportClient esClient;
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public Result<ItemSearchResultDTO> search(String keyword, String category, String brand, String spec,
                                              String price, String sort, long currentPage, long pageSize) {
        // 构建查询
        SearchResponse searchResponse = buildQuery(keyword, category, brand, spec, price, sort, currentPage, pageSize);
        SearchHits hits = searchResponse.getHits();
        long totalHits = hits.totalHits;
        // 获取item列表
        List<ItemSearchDTO> itemList = getItemList(hits);
        // 获取商品分类列表
        List<String> categoryList = getCategoryList(searchResponse);
        //获取品牌和规格列表
        Map<String, List<Map>> brandAndSpecList = Collections.EMPTY_MAP;
        if (null != category && !category.equals("")) {
            brandAndSpecList = getBrandAndSpecList(category);
        } else {
            if (categoryList.size() > 0) {
                brandAndSpecList = getBrandAndSpecList(categoryList.get(0));
            }
        }
        ItemSearchResultDTO resultDTO = new ItemSearchResultDTO();
        resultDTO.setCategoryList(categoryList);
        resultDTO.setBrandList(brandAndSpecList.get("brandList"));
        resultDTO.setSpecList(brandAndSpecList.get("specList"));
        resultDTO.setPageResult(new PageResult<>(null, 1L, 40L, totalHits, itemList));
        return ResultUtils.successResult(resultDTO);
    }

    private SearchResponse buildQuery(String keyword, String category, String brand, String spec,
                                      String price, String sort, long currentPage, long pageSize) {

        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        if (null != category && !"".equals(category)) {
            boolQuery.filter(QueryBuilders.termQuery("category", category));
        }
        if (null != brand && !"".equals(brand)) {
            boolQuery.filter(QueryBuilders.termQuery("brand", brand));
        }
        ItemAttributesBlock priceBlock = ItemAttributesBlock.matchPrice(price);
        if (!ItemAttributesBlock.ALL.equals(priceBlock)) {
            RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("price");
            if (priceBlock.getMax() > 0) {
                rangeQuery.lte(priceBlock.getMin().doubleValue());
            }
            if (priceBlock.getMin() > 0) {
                rangeQuery.gte(priceBlock.getMax().doubleValue());
            }
            boolQuery.filter(rangeQuery);
        }

        boolQuery.must(QueryBuilders.multiMatchQuery(keyword, "title", "brand", "seller"));
        HighlightBuilder high = new HighlightBuilder();
        high.preTags("<em style=\"color: #e4393c\">");
        high.postTags("</em>");
        high.field("title");
        String[] sortArr = sort.split(":");
        SearchRequestBuilder searchBuilder = esClient.prepareSearch(esIndex)
                .setTypes(esType)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(boolQuery)
                .setFrom(Math.toIntExact(currentPage))
                .setSize(Math.toIntExact(pageSize))
                .setExplain(true)
                .highlighter(high)
                //此处可以根据重载方法动态指定返回哪些字段的内容
                .setFetchSource(true)
                // 对搜索关键词的category分组
                .addAggregation(AggregationBuilders.terms("category_type").field("category"));
        if (sortArr.length > 0 && null != sortArr[0] && !"".equals(sortArr[0])) {
            searchBuilder.addSort(sortArr[0], SortOrder.fromString(sortArr[1]));
        }
        return searchBuilder.get();
    }

    /**
     * 获取商品列表
     *
     * @param hits
     * @return List<ItemSearchDTO>
     */
    private List<ItemSearchDTO> getItemList(SearchHits hits) {
        List<ItemSearchDTO> itemList = new ArrayList<>();
        hits.forEach(hit -> {
            ItemSearchDTO itemSearchDTO = new Gson().fromJson(hit.getSourceAsString(), ItemSearchDTO.class);
            Map<String, HighlightField> highlightMap = hit.getHighlightFields();
            String title;
            if (!CollectionUtils.isEmpty(highlightMap)) {
                title = highlightMap.get("title").getFragments()[0].toString();
            } else {
                title = itemSearchDTO.getTitle();
            }
            itemSearchDTO.setTitle(title);
            itemList.add(itemSearchDTO);
        });
        return itemList;
    }

    /**
     * 获取类目列表
     *
     * @param searchResponse 响应结果
     * @return List<String>
     */
    private List<String> getCategoryList(SearchResponse searchResponse) {
        StringTerms terms = searchResponse.getAggregations().get("category_type");
        List<String> categoryList = new ArrayList<>(terms.getBuckets().size());
        terms.getBuckets().forEach(bucket -> {
            categoryList.add(bucket.getKeyAsString());
        });
        return categoryList;
    }

    /**
     * 获取品牌&规格列表
     *
     * @param category 类目名称
     * @return Map<String, List < String>>
     */
    private Map<String, List<Map>> getBrandAndSpecList(String category) {
        Map<String, List<Map>> map = new HashMap<>();
        // 1.根据商品分类名称获取模板ID
        Integer typeId = (Integer) redisUtils.hget("cateInfo", category);
        Long templateId = Long.valueOf(typeId);
        if (Objects.nonNull(templateId)) {
            // 2.根据模板ID获取品牌列表
            List brandList = (List) redisUtils.hget("brandList", String.valueOf(templateId));
            map.put("brandList", brandList);
            // 3.根据模板ID获取规格列表
            List specList = (List) redisUtils.hget("specList", String.valueOf(templateId));
            map.put("specList", specList);
        }
        return map;
    }

    @Override
    public Result<List<String>> suggest(String keyword) {
        CompletionSuggestionBuilder suggestion = SuggestBuilders.completionSuggestion("suggest").prefix(keyword).size(5);
        SuggestBuilder builder = new SuggestBuilder();
        builder.addSuggestion("autocomplete", suggestion);
        SearchRequestBuilder searchBuilder = esClient.prepareSearch(esIndex).setTypes(esType).suggest(builder);
        SearchResponse searchResponse = searchBuilder.get();
        Suggest suggest = searchResponse.getSuggest();
        Suggest.Suggestion result = suggest.getSuggestion("autocomplete");
        Set<String> suggestSet = new HashSet<>();
        int maxSuggest = 0;
        for (Object term : result.getEntries()) {
            if (term instanceof CompletionSuggestion.Entry) {
                CompletionSuggestion.Entry item = (CompletionSuggestion.Entry) term;
                if (item.getOptions().isEmpty()) {
                    continue;
                }
                for (CompletionSuggestion.Entry.Option option : item.getOptions()) {
                    String tip = option.getText().string();
                    if (suggestSet.contains(tip)) {
                        continue;
                    }
                    suggestSet.add(tip);
                    maxSuggest++;
                }
            }
            if (maxSuggest > 5) {
                break;
            }
        }
        List<String> suggests = Lists.newArrayList(suggestSet.toArray(new String[]{}));
        return ResultUtils.successResult(suggests);
    }
}
