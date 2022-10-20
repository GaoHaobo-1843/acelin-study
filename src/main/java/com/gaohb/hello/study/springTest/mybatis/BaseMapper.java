package com.gaohb.hello.study.springTest.mybatis;

import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * 通用Mapper
 * @author Admin
 * @param <T>
 */
public interface BaseMapper<T> extends Mapper<T>, InsertListMapper<T> {

}
