package com.youxuan.common.utils.result.exception;

import com.youxuan.common.utils.result.Result;

/**
 * @Author: Jebe
 * @Date: 2019/12/21
 * @Desc TODO
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 返回码
     */
    private Result result;

    /**
     * 异常消息参数
     */
    protected Object[] args;

    public BaseException(Result result) {
        super(result.getMsg());
        this.result = result;
    }
}
