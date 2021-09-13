package com.gaohb.hello.study.config.test;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

import java.time.Duration;
import java.util.List;

@ConfigurationProperties(
        prefix = "hello.properties"
)

public class MyProperties {

    private String myKey;
    private List<String> stringList;
    private Duration duration;

    public String getMyKey() {
        return myKey;
    }

    public void setMyKey(String myKey) {
        this.myKey = myKey;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "MyProperties{" +
                "myKey='" + myKey + '\'' +
                ", stringList=" + stringList +
                ", duration=" + duration +
                '}';
    }
}
