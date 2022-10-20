package com.gaohb.hello.study.springTest.mybatis.sequence;

/**
 * 序列值生成器
 * @author Admin
 * @param <T>
 */
public interface ISeqGenerator<T> {

    /**
     * 生成Id
     * @param table
     * @param column
     * @return
     */
    T genId(String table, String column);
}
