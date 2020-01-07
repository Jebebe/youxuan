package com.youxuan.search.service.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author: Jebe
 * @Date: 2019/12/29
 * @Desc ES配置
 */
@Configuration
public class ESConfig {

    @Value("${es.host}")
    private String esHost;
    @Value("${es.port}")
    private int esPort;
    @Value("${es.cluster-name}")
    private String esClusterName;

    @Bean
    public TransportClient esClient() throws UnknownHostException {
        Settings settings = Settings.builder()
                .put("cluster.name", esClusterName)
                .put("client.transport.sniff", true)
                .build();
        TransportAddress address = new TransportAddress(InetAddress.getByName(esHost), esPort);
        return new PreBuiltTransportClient(settings).addTransportAddress(address);
    }
}
