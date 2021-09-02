package com.gaohb.hello.study.basemapper;

import tk.mybatis.mapper.common.Mapper;

/**
 * TableMapper，单表都继承此TableMapper.
 */
public interface TableMapper<T> extends Mapper<T> {

}
