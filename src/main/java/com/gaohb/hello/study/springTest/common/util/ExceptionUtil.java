package com.gaohb.hello.study.springTest.common.util;

import java.util.Objects;

import org.apache.commons.lang3.exception.ExceptionUtils;

/**
 * 异常工具类
 * @author Admin
 */
public final class ExceptionUtil extends ExceptionUtils {

    private ExceptionUtil() {

    }

    /**
     * 把异常包装成RuntimeException抛出去
     * @param throwable
     */
    public static void throwRuntimeException(final Throwable throwable) {
        if (Objects.isNull(throwable)) {
            return;
        }

        throw wrapToRuntimeException(throwable);
    }

    /**
     * 把异常包装成RuntimeException
     * @param throwable
     * @return
     */
    public static RuntimeException wrapToRuntimeException(final Throwable throwable) {
        if (Objects.isNull(throwable)) {
            return null;
        }

        if (throwable instanceof RuntimeException) {
            return (RuntimeException) throwable;
        }

        return new RuntimeException(throwable);
    }

    /**
     * 抛出RuntimeException
     * @param message
     */
    public static void throwRuntimeException(final String message) {
        throw new RuntimeException(message);
    }
}
