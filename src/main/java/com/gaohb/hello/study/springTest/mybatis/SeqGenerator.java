package com.gaohb.hello.study.springTest.mybatis;

import org.apache.commons.lang3.StringUtils;

import com.gaohb.hello.study.springTest.common.SymbolConsts;
import com.gaohb.hello.study.springTest.mybatis.sequence.ISeqGenerator;
import com.gaohb.hello.study.springTest.mybatis.sequence.SeqUtils;

/**
 * 序列值生成器
 * @author Admin
 */
public class SeqGenerator implements ISeqGenerator<String> {

    @Override
    public String genId(String table, String column) {
        String seqName = String.join(SymbolConsts.UNDERLINE, SeqUtils.PREFIX_SEQ, StringUtils.upperCase(table),
            SeqUtils.SUFFIX_ID);
        return SeqUtils.getNext(seqName);
    }
}
