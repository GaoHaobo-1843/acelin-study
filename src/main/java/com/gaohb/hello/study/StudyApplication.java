package com.gaohb.hello.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
//@ConfigurationPropertiesScan
public class StudyApplication {

    public static void main(String[] args) {

        SpringApplication.run(StudyApplication.class, args);
    }

}
