package com.gaohb.hello.study.springTest.log;

import com.gaohb.hello.study.config.base.Base;
import org.springframework.stereotype.Component;

@Component
public class LoggerTest extends Base {

    public void logTest(){
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }
}
