package com.gaohb.hello.study.springTest.redis;

import com.alibaba.fastjson.JSONObject;
import com.gaohb.hello.study.config.redis.properties.MyRedisProperties;
import com.gaohb.hello.study.config.test.MyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
//@EnableConfigurationProperties(MyProperties.class)
public class RedisController {

    @Autowired
    private RedisService redisService;

    @Resource
    private MyRedisProperties myRedisProperties;

    @Resource
    private MyProperties myProperties;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @RequestMapping("/redisPros")
    @ResponseBody
    public String  redisPros(){
        return JSONObject.toJSONString(myRedisProperties);
    }

    @RequestMapping("/myPros")
    @ResponseBody
    public String myPros(){
        return myProperties.toString();
    }

    @RequestMapping("/setData")
    public void setData(){
        long timeStr = System.currentTimeMillis();
        System.out.println(timeStr);
        redisService.set(String.valueOf(timeStr),timeStr + " nice");
    }


    @RequestMapping("/getData/{key}")
    public void getData(@PathVariable("key") String key){
        System.out.println(redisService.get(key,String.class));
    }



    @RequestMapping("/setDataSpring")
    public void setDataSpring(){
        long timeStr = System.currentTimeMillis();
        System.out.println(timeStr);
        redisTemplate.opsForValue().set(String.valueOf(timeStr),timeStr + " nice");
    }



}
