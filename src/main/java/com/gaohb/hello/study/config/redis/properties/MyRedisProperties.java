package com.gaohb.hello.study.config.redis.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@ConfigurationProperties(
        prefix = "spring.redis"
)
@Component
@PropertySource("classpath:/redis.properties")
public class MyRedisProperties {
    private String database;
    private String host;
    private Integer port;
    private String password;
    private Integer timeOut;

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Integer getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Integer timeOut) {
        this.timeOut = timeOut;
    }

    @Override
    public String toString() {
        return "RedisPorperties{" +
                "database='" + database + '\'' +
                ", host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", password='" + password + '\'' +
                ", timeOut=" + timeOut +
                '}';
    }
}
