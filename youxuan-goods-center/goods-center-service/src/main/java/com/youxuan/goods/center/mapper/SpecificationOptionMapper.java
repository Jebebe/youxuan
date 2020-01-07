package com.youxuan.goods.center.mapper;

import com.youxuan.goods.center.entity.SpecificationOption;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.youxuan.common.utils.mapper.BaseMapper
        ;

import java.util.List;

@Repository
public interface SpecificationOptionMapper extends BaseMapper<SpecificationOption, Long> {

    /**
     * 根据规格ID查询所有选项
     * @param specId    规格ID
     * @return List<SpecificationOption>
     */
    List<SpecificationOption> selectSpecOptionsBySpecId(@Param("specId") Long specId);
}