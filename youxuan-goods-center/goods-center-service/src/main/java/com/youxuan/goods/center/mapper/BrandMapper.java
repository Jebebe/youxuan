package com.youxuan.goods.center.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youxuan.common.utils.mapper.BaseMapper;
import com.youxuan.goods.center.api.param.BrandSearchParamDTO;
import com.youxuan.goods.center.entity.Brand;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandMapper extends BaseMapper<Brand, Long> {

    /**
     * 查询所有品牌
     * @return List
     */
    List<Brand> selectAllBrand();

    /**
     * 品牌搜索分页列表
     * @param page
     * @param brand
     * @return IPage<Brand>
     */
    IPage<Brand> selectBrandPageList(@Param("page") Page<Brand> page, @Param("brand") BrandSearchParamDTO brand);

    /**
     * 批量删除品牌
     * @param ids
     * @param updatedBy
     * @return int
     */
    int batchDelete(@Param("ids") List<Long> ids, @Param("updatedBy") Long updatedBy);

}