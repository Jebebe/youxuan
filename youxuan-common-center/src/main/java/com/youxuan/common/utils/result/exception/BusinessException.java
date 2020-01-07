package com.youxuan.common.utils.result.exception;

import com.youxuan.common.utils.result.Result;

/**
 * Created by kinginblue on 2017/1/11.
 * <p>
 * 自定义业务异常
 */
public class BusinessException extends BaseException {

    private static final long serialVersionUID = 1L;


    public BusinessException(Result result) {
        super(result);
    }
}
