package com.youxuan.common.utils.result;

import java.util.List;

/**
 * @Author: Jebe
 * @Date: 2019/12/19 11:20
 * @Desc REST 响应信息工具类
 */
public class ResultUtils {

    public static <T> Result<T> successResult(T data) {
        return new Result<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg()).setData(data);
    }

    public static <T> Result<PageResult<T>> successPageResult(Long totalPage, Long currentPage, Long pageSize, Long totalSize, List<T> data) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setCurrentPage(currentPage);
        pageResult.setPageSize(pageSize);
        pageResult.setTotalPage(totalPage);
        pageResult.setTotalSize(totalSize);
        pageResult.setList(data);
        return new Result<PageResult<T>>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg()).setData(pageResult);
    }

    public static <T> Result<PageResult<T>> successPageResult(List<T> data) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setList(data);
        return new Result<PageResult<T>>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg()).setData(pageResult);
    }

    public static <T> Result<T> successResult() {
        return new Result<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg());
    }

    public static <T> Result<T> failResult(ResultCode resultCode) {
        return new Result<T>(resultCode.getCode(), resultCode.getMsg());
    }

    public static <T> Result<T> failResult(String code, String msg) {
        return new Result<T>(code, msg);
    }

    public static <T> Result<T> failResult(String msg) {
        Result<T> result = new Result<T>();
        result.setCode("-1");
        result.setMsg(msg);
        return result;
    }

    public static <T> Result<T> failResult(T t) {
    	Result<T> result = new Result<T>();
    	result.setCode("-1");
    	result.setData(t);
    	return result;
    }
}
