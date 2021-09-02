package com.gaohb.hello.study.config.redis.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@ConfigurationProperties(
        prefix = "spring.redis.cluster"
)
@Component
@PropertySource("classpath:/redis.properties")
public class RedisClusterProperties {

    private String expireSeconds;
    private Integer commandTimeout;
    private String nodes;

    public String getExpireSeconds() {
        return expireSeconds;
    }

    public void setExpireSeconds(String expireSeconds) {
        this.expireSeconds = expireSeconds;
    }

    public Integer getCommandTimeout() {
        return commandTimeout;
    }

    public void setCommandTimeout(Integer commandTimeout) {
        this.commandTimeout = commandTimeout;
    }

    public String getNodes() {
        return nodes;
    }

    public void setNodes(String nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        return "RedisClusterProperties{" +
                "expireSeconds='" + expireSeconds + '\'' +
                ", commandTimeout='" + commandTimeout + '\'' +
                ", nodes='" + nodes + '\'' +
                '}';
    }
}
