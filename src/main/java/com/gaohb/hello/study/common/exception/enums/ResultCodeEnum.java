package com.gaohb.hello.study.common.exception.enums;

/**
 * @author Admin
 */
public enum ResultCodeEnum implements IResultCode {

    /** 成功 */
    SUCCESS("0", "success"),
    /** 失败 */
    FAIL("-1", "fail"),

    EMPTY("", "");

    private String code;
    private String message;

    ResultCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage(Object... args) {
        return message;
    }
}
