package com.youxuan.goods.center.exception;

import com.alibaba.fastjson.JSONObject;
import com.youxuan.common.utils.result.Result;
import com.youxuan.common.utils.result.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @Author: Jebe
 * @Date: 2019/12/21
 * @Desc 全局异常处理
 */
@Slf4j
// @ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        Result<Object> result = new Result<>();
        result.setMsg("错误的请求");
        result.setCode("-1");
        result.setData(e.getMessage());
        log.error(JSONObject.toJSONString(result));
        return result;
    }

    /**
     * 请求方式异常
     * @param e
     * @return Result
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result<Object> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        Result<Object> result = new Result<>();
        result.setMsg("请求方式不支持");
        result.setCode("-1");
        result.setData(e.getMessage());
        log.error(JSONObject.toJSONString(result));
        return result;
    }

    /**
     * 处理所有不可知的异常
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handleException(Exception e) {
        Result<Object> result = new Result<>();
        result.setMsg("内部服务异常");
        result.setCode("-1");
        result.setData(e.getMessage());
        log.error(JSONObject.toJSONString(result));
        return result;
    }

    /**
     * 处理所有业务异常
     */
    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public Result handleBusinessException(BusinessException e) {
        Result<Object> result = new Result<>();


        return null;
    }

    /**
     * 处理所有接口数据验证异常
     */
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Result<Object> result = new Result<>();
        result.setCode("-1");
        result.setMsg("方法参数有误");
        result.setData(e.getMessage());
        log.error(JSONObject.toJSONString(result));
        return result;
    }
}
