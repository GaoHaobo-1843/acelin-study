package com.gaohb.hello.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//@ConfigurationPropertiesScan
@MapperScan("com.gaohb.hello.study.springTest.common.mapper")
public class StudyApplication {

    public static void main(String[] args) {

        SpringApplication.run(StudyApplication.class, args);
    }

}
