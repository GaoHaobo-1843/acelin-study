package com.gaohb.hello.study.springTest.mybatis.sequence;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import com.alibaba.druid.util.JdbcConstants;
import com.gaohb.hello.study.springTest.common.SymbolConsts;
import com.gaohb.hello.study.springTest.common.util.SpringUtils;
import com.gaohb.hello.study.springTest.mybatis.TransactionUtils;

/**
 * 序列工具类
 * @author Admin
 */
public final class SeqUtils {

    public static final String PREFIX_SEQ = "SEQ";
    public static final String SUFFIX_ID = "ID";
    public static final String DB_TYPE_UDAL = "udal";

    private SeqUtils() {

    }

    /**
     * 根据表名和字段名获取序列值<br>
     * 序列名：SEQ_upper(table)_upper(column)
     * @param table
     * @param column
     * @return
     */
    public static String getNext(String table, String column) {
        Assert.hasText(table, "table must not be empty");
        Assert.hasText(table, "column must not be empty");
        return getNext(String.join(SymbolConsts.UNDERLINE, PREFIX_SEQ, StringUtils.upperCase(table),
            StringUtils.upperCase(column)));
    }

    /**
     * 根据序列名获取序列值
     * @param seqName
     * @return
     */
    public static String getNext(String seqName) {
        Assert.hasText(seqName, "seqName must not be empty");
        return TransactionUtils.executeNew(() -> {
            String dbType = SpringUtils.getEnvironment().getProperty("jdbc.seq.db-type", JdbcConstants.MYSQL.name());
            String sql = "";
            if (StringUtils.equalsIgnoreCase(JdbcConstants.MYSQL.name(), dbType)) {
                sql = "select nextval('" + seqName + "') seq_value";
            }
            else if (StringUtils.equalsIgnoreCase(JdbcConstants.ORACLE.name(), dbType)) {
                sql = "select " + seqName + ".nextval from dual";
            }
            else if (StringUtils.equalsIgnoreCase(DB_TYPE_UDAL, dbType)) {
                sql = "select " + seqName + ".nextval";
            }
            else {
                throw new RuntimeException("unknown dbType");
            }

            JdbcTemplate jdbcTemplate = SpringUtils.getBean(JdbcTemplate.class);
            return jdbcTemplate.queryForObject(sql, String.class);
        });
    }
}
