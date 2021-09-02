package com.gaohb.hello.study.springTest.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
public class RedisClusterController {

    @Autowired
    @Qualifier("redisClusterService")
    private IRedisCluster redisCluster;

    @Autowired
    @Qualifier("redisClusterTemplateService")
    private IRedisCluster redisTemplateCluster;

    @PostMapping("/cluster/{key}")
    public void setData(@PathVariable("key") String key){
        System.out.println("set " + key);
        redisTemplateCluster.set(key,key + " nice");
    }

    @GetMapping("/cluster/{key}")
    public void getData(@PathVariable("key") String key){

        System.out.println(redisTemplateCluster.get(key));
    }

    @PostMapping("/cluster/jedis/{key}")
    public void setDataByJedis(@PathVariable("key") String key){
        System.out.println("set " + key);
        redisCluster.set(key,key + " nice");
    }

    @GetMapping("/cluster/jedis/{key}")
    public void getDataByJedis(@PathVariable("key") String key){
        System.out.println(redisCluster.get(key));
    }


}
