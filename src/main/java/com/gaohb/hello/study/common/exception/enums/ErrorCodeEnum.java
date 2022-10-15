package com.gaohb.hello.study.common.exception.enums;

import java.text.MessageFormat;

import com.gaohb.hello.study.common.exception.BusinessException;

/**
 * 错误编码枚举
 * 
 * @author Admin
 */
public enum ErrorCodeEnum implements IResultCode {

    /** 没有通过Spring的事务管控，不允许获取连接 */
    TRANSACTION_ERROR("1001", "没有通过Spring的事务管控，不允许获取连接"),

    /** 非法请求，请重新登录 */
    LOGIN_ERROR("1002", "非法请求，请重新登录"),


    EMPTY("", "");

    private String code;

    private String message;

    ErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage(Object... args) {
        return MessageFormat.format(message, args);
    }

    public void throwException(Object... args) {
        throw new BusinessException(this.getCode(), this.getMessage(args));
    }

    public void throwExceptionData(Object data, Object... args) {
        throw new BusinessException(this.getCode(), this.getMessage(args), data);
    }

    public void throwException(Throwable cause) {
        throw new BusinessException(this, cause);
    }
}
