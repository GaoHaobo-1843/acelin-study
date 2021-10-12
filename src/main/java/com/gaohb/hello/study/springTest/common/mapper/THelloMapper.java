package com.gaohb.hello.study.springTest.common.mapper;

import com.gaohb.hello.study.basemapper.TableMapper;
import com.gaohb.hello.study.springTest.mybatis.THello;
import org.springframework.stereotype.Repository;

@Repository
public interface THelloMapper extends TableMapper<THello> {
}