package com.gaohb.hello.study.springTest.logTest;

import com.gaohb.hello.study.springTest.log.LoggerTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LogTest {

    @Autowired
    private LoggerTest loggerTest;

    @Test
    public void producer(){
        try{
            loggerTest.logTest();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
