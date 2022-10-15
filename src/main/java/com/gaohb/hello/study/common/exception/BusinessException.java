package com.gaohb.hello.study.common.exception;

import com.gaohb.hello.study.common.exception.enums.IResultCode;

/**
 * 业务异常
 * @author Admin
 */
@SuppressWarnings("serial")
public class BusinessException extends RuntimeException {

    private String code;

    private Object data;

    public BusinessException() {
        super();
    }

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(String code, String message, Object data) {
        super(message);
        this.code = code;
        this.data = data;
    }

    public BusinessException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public BusinessException(IResultCode resultCode) {
        super(resultCode.getMessage());
        this.code = resultCode.getCode();
    }

    public BusinessException(IResultCode resultCode, Throwable cause) {
        super(resultCode.getMessage(), cause);
        this.code = resultCode.getCode();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
