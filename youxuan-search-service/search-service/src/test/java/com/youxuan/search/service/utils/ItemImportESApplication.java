package com.youxuan.search.service.utils;

import com.youxuan.common.utils.result.Result;
import com.youxuan.goods.center.entity.Item;
import com.youxuan.search.service.feign.GoodsCenterService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.IOException;
import java.util.List;
import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * @Author: jebe
 * @Date: 2019/12/29 20:08
 * @Desc 商品导入ES工具类
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ItemImportESApplication.class)
@ComponentScan(basePackages = {"com.youxuan.search.service"})
public class ItemImportESApplication {

    @Autowired
    private TransportClient esClient;
    @Autowired
    private GoodsCenterService goodsCenterService;

    @Test
    public void itemImport() {

        BulkRequestBuilder bulkRequest = esClient.prepareBulk();
        // 获取所有商品
        Result<List<Item>> allItemList = goodsCenterService.getAllItemList();
        allItemList.getData().forEach(item -> {
            try {
                bulkRequest.add(esClient.prepareIndex("youxuan", "item", String.valueOf(item.getId()))
                        .setSource(jsonBuilder()
                                .startObject()
                                .field("itemId", item.getId())
                                .field("goodsId", item.getGoodsId())
                                .field("price", item.getPrice().doubleValue())
                                .field("imageUrl", item.getImageUrl())
                                .field("title", item.getTitle())
                                .field("category", item.getCategoryName())
                                .field("seller", item.getSellerId())
                                .field("brand", item.getBrandName())
                                .endObject()
                        )
                );
            } catch (IOException e) {
                e.printStackTrace();
                log.error(">>>>>>[商品导入失败]<<<<<<");
            }
        });

        BulkResponse bulkResponses = bulkRequest.get();
        boolean result = bulkResponses.hasFailures();
        log.info("hasFailures: {}", result);
        esClient.close();
    }

}
