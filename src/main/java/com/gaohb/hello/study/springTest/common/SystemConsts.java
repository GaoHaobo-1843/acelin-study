package com.gaohb.hello.study.springTest.common;

import java.io.File;

/**
 * 系统常量
 * @author Admin
 */
public interface SystemConsts {

    /**
     * CheckStyle要求接口必须拥有方法
     */
    void empty();

    String USER_ID = "User-Id";

    String USER_ROLE = "User-Role";

    String USER_CODE = "User-Code";

    String CREATE_DATE = "createDate";

    String UPDATE_DATE = "updateDate";

    String CREATE_USER = "createUser";

    String UPDATE_USER = "updateUser";

    String STATUS_DATE = "statusDate";

    String STATUS_CD = "statusCd";

    String TEMP_DIR = new StringBuilder().append(System.getProperty("user.home")).append(File.separator)
        .append("autotest").toString();

    String TEMPLATE_PARAM_NAME = "param";

    String DEFAULT_BY_TYPE = "By.XPATH";

    String DEFAULT_BROWSER_TYPE = "1";

    String DEFAULT_CASE_CODE = "TestCase";

    /**
     * 半小时30分钟
     */
    int MINUTES_HALF_HOUR = 30;

    /**
     * 三小时180分钟
     */
    int MINUTES_THREE_HOUR = 180;

    /**
     * 半小时1800秒
     */
    int SECONDS_HALF_HOUR = 1800;

    /**
     * 1小时3600秒
     */
    int SECONDS_ONE_HOUR = 3600;

    /**
     * 1分钟60秒
     */
    int SECONDS_ONE_MINUTE = 60;

    /**
     * 3秒
     */
    int SECONDS_3 = 3;

    /**
     * 5秒
     */
    int SECONDS_5 = 5;

    /**
     * 30秒
     */
    int SECONDS_30 = 30;

    /**
     * 50秒
     */
    int SECONDS_50 = 50;

    /**
     * 1分钟60000毫秒
     */
    int MILLS_ONE_MINUTE = 60000;

    /**
     * 一个月31天
     */
    int DAYS_ONE_MONTH = 31;

    int DEFAULT_CONCURRENT_NUM = 5;

    /**
     * 发送通知标识(0：不发送)
     */
    String SEND_STATUS_0 = "0";

    /**
     * 发送通知标识(1：发送)
     */
    String SEND_STATUS_1 = "1";

    /**
     * 钉钉发送类型(1：通过关键字发送)
     */
    String DINGTALK_SEND_TYPE_1 = "1";

    /**
     * 钉钉发送类型(2：通过秘钥发送)
     */
    String DINGTALK_SEND_TYPE_2 = "2";

    String INTERFACE_COOKIE = "INTERFACE_COOKIE";

    String INTERFACE_HEADER = "INTERFACE_HEADER";

    String SESSION_ID = "Session-Id";

    String ACCESS_TOKEN = "X-Access-Token";

    String KEY_CACHE_TYPE = "cache.type";

    String KEY_DFS_TYPE = "dfs.type";

    String DFS_TYPE_FDFS = "fdfs";

    String EXECUTE_QUEUE_ID = "Execute-Queue-Id";

    String SERIAL_NUMBER = "Serial-Number";

    String SUFFIX_XLSX = ".xlsx";

    String SUFFIX_ZIP = ".zip";

    String SUFFIX_XML = ".xml";

    int NUM_0 = 0;

    int NUM_1 = 1;

    int NUM_2 = 2;

    int NUM_3 = 3;

    int NUM_4 = 4;

    int NUM_5 = 5;

    int NUM_6 = 6;

    int NUM_7 = 7;

    int NUM_8 = 8;

    int NUM_9 = 9;

    int NUM_10 = 10;

    int NUM_100 = 100;

    String JOB_GROUP_LOAD_TEST = "LOAD_TEST";
    String JOB_GROUP_WARN_RULE = "WARN_RULE";

    String MASKING = "********";

    /**
     * key
     */
    String APP_KEY = "ssodr.appKey";

    /**
     * appSecret
     */
    String APP_SECRET = "ssodr.appSecret";

    /**
     * ignoreTokenUrls
     */
    String IGNORE_TOKEN_URLS = "ssodr.ignoreTokenUrls";

    /**
     * TOKEN key
     */
    String KEY_TOKEN = "TOKEN";

    /**
     * 单点登录类型
     */
    String SSODR_LOGIN_TYPE = "ssodr";

    String DEFAULT_LOGIN_URL = "login.url";

    String LOGIN_TYPE = "login.type";

    String SSODR_URL = "ssodr.url";

    String SSODR_CONTEXT = "ssodr.context";

    String SSODR_REDIRECT_URL = "ssodr.ssodrRedirectUrl";

    String SCHEME_HTTP = "http://";

    /**
     * 复制的后缀
     */
    String COPY_NAME_SUFFIX = "_副本";

    Integer MAX_AUTO_RETRY_TIME = 3;
    Integer DEFAULT_AUTO_RETRY_TIME = 1;
}
