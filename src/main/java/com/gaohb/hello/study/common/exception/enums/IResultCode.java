package com.gaohb.hello.study.common.exception.enums;

/**
 * @author Admin
 */
public interface IResultCode {

    /**
     * 获取结果编码
     * @return
     */
    String getCode();

    /**
     * 获取结果信息
     * @param args
     * @return
     */
    String getMessage(Object... args);
}
