package com.youxuan.goods.center.mapper;

import com.youxuan.common.utils.mapper.BaseMapper;
import com.youxuan.goods.center.entity.TypeTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeTemplateMapper extends BaseMapper<TypeTemplate, Long> {

    /**
     * 查询类型模板列表
     * @return List<TypeTemplate>
     */
    List<TypeTemplate> selectTypeTempList();
}