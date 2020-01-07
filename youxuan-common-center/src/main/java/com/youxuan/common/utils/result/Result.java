package com.youxuan.common.utils.result;

import java.io.Serializable;

/**
 * @Author: Jebe
 * @Date: 2019/12/19 11:47
 * @Desc 结果对象
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 8291272403611347925L;

    /**
     * 结果码，200正常
     */
    private String code;

    /**
     * 返回的消息
     */
    private String msg;

    /**
     * 返回的内容
     */
    private T data;

    public <T> Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public <T> Result() {
    }

    public Result<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public Result<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public T getData() {
        return this.data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    public Result(String code, String msg, T data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result getErrorResult(ResultCode resultCode) {
        return new Result(resultCode.getCode(), resultCode.getMsg());
    }

    public static <T> Result<T> getSuccessResult(T t) {
        return new Result<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), t);
    }
}
