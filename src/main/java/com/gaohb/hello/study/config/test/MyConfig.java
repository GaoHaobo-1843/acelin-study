package com.gaohb.hello.study.config.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@Import(MyProperties.class)
public class MyConfig {

//    @Bean
//    public RedisProperties getRedisConfig(){
//        return new RedisProperties();
//    }

    @Bean
    public MyProperties getMyProperties(){
        return new MyProperties();
    }
}
