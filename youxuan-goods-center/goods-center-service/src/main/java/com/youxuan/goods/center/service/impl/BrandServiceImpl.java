package com.youxuan.goods.center.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youxuan.common.utils.bean.BeanUtils;
import com.youxuan.common.utils.result.PageResult;
import com.youxuan.common.utils.result.Result;
import com.youxuan.common.utils.result.ResultUtils;
import com.youxuan.goods.center.api.param.BrandAddParamDTO;
import com.youxuan.goods.center.api.param.BrandDeleteParamDTO;
import com.youxuan.goods.center.api.param.BrandUpdateParamDTO;
import com.youxuan.goods.center.api.result.BrandListResultDTO;
import com.youxuan.goods.center.api.param.BrandSearchParamDTO;
import com.youxuan.goods.center.entity.Brand;
import com.youxuan.goods.center.mapper.BrandMapper;
import com.youxuan.goods.center.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @Author: jebe
 * @Date: 2019/12/18 20:28
 */
@Service("brandService")
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<BrandListResultDTO> getAllBrand() {
        List<Brand> brandList = brandMapper.selectAllBrand();
        return BeanUtils.mapList(brandList, BrandListResultDTO.class);
    }

    @Override
    public Result<PageResult<BrandListResultDTO>> getBrandPageList(BrandSearchParamDTO brandParamDTO) {

        Page<Brand> page = new Page<>();
        page.setCurrent(brandParamDTO.getCurrentPage());
        page.setSize(brandParamDTO.getPageSize());
        IPage<Brand> brandIPage = brandMapper.selectBrandPageList(page, brandParamDTO);
        List<BrandListResultDTO> list = Collections.EMPTY_LIST;
        if (!CollectionUtils.isEmpty(brandIPage.getRecords())) {
            list = BeanUtils.mapList(brandIPage.getRecords(), BrandListResultDTO.class);
        }
        return ResultUtils.successPageResult(brandIPage.getTotal(), brandIPage.getCurrent(), brandIPage.getSize(), brandIPage.getSize(), list);
    }

    @Override
    public Result<Boolean> add(BrandAddParamDTO brandAdd) {
        Brand brand = BeanUtils.map(brandAdd, Brand.class);
        brand.setStatus(1).setCreatedBy(1L).setCreatedTime(LocalDateTime.now()).setIsDeleted(false);
        int result = brandMapper.insert(brand);
        return ResultUtils.successResult(result > 0);
    }

    @Override
    public Result<Boolean> update(BrandUpdateParamDTO update) {
        Brand brand = BeanUtils.map(update, Brand.class);
        brand.setUpdatedTime(LocalDateTime.now()).setUpdatedBy(1L);
        int result = brandMapper.updateByPrimaryKeySelective(brand);
        return ResultUtils.successResult(result > 0);
    }

    @Override
    public Result<Boolean> delete(BrandDeleteParamDTO delete) {

        Long updatedBy = 1L;
        int result = brandMapper.batchDelete(delete.getIds(), updatedBy);
        return ResultUtils.successResult(result > 0);
    }

    @Override
    public Result<BrandListResultDTO> details(Long id) {
        Brand brand = brandMapper.selectByPrimaryKey(id);
        BrandListResultDTO resultDTO = BeanUtils.map(brand, BrandListResultDTO.class);
        return ResultUtils.successResult(resultDTO);
    }
}
