package com.youxuan.goods.center.service;

import com.youxuan.common.utils.result.PageResult;
import com.youxuan.common.utils.result.Result;
import com.youxuan.goods.center.api.param.BrandAddParamDTO;
import com.youxuan.goods.center.api.param.BrandDeleteParamDTO;
import com.youxuan.goods.center.api.param.BrandUpdateParamDTO;
import com.youxuan.goods.center.api.result.BrandListResultDTO;
import com.youxuan.goods.center.api.param.BrandSearchParamDTO;
import com.youxuan.goods.center.entity.Brand;

import java.util.List;

/**
 * @Author: jebe
 * @Date: 2019/12/18 20:26
 */
public interface BrandService {

    /**
     * 获取所有品牌
     *
     * @return List<BrandResultDTO>
     */
    List<BrandListResultDTO> getAllBrand();

    /**
     * 品牌分页列表
     *
     * @param brandParamDTO
     */
    Result<PageResult<BrandListResultDTO>> getBrandPageList(BrandSearchParamDTO brandParamDTO);

    /**
     * 新增品牌
     *
     * @param brandAdd
     * @return Result<Boolean>
     */
    Result<Boolean> add(BrandAddParamDTO brandAdd);

    /**
     * 品牌更新
     * @param update
     * @return Result<Boolean>
     */
    Result<Boolean> update(BrandUpdateParamDTO update);

    /**
     * 批量删除品牌
     * @param delete
     * @return Result<Boolean>
     */
    Result<Boolean> delete(BrandDeleteParamDTO delete);

    /**
     * 获取品牌详情
     * @param id
     * @return Result<BrandListResultDTO>
     */
    Result<BrandListResultDTO> details(Long id);
}
