package com.youxuan.common.utils.result;

import org.springframework.util.StringUtils;

/**
 * @Author: Jebe
 * @Date: 2019/12/19 11:36
 * @Desc 返回码
 */
public enum ResultCode {

    SUCCESS("200", "SUCCESS");

    private String code;
    private String msg;

    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static ResultCode find(String code) {
        if (StringUtils.isEmpty(code)) {
            return null;
        }
        for (ResultCode resultCode : ResultCode.values()) {
            if (code.equals(resultCode.code)) {
                return resultCode;
            }
        }
        return null;
    }

}
