package com.gaohb.hello.study.springTest.mybatis;

import com.gaohb.hello.study.config.base.Base;
import com.gaohb.hello.study.springTest.common.mapper.THelloMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mybatis")
public class MybatisController extends Base {

    @Autowired
    private THelloMapper tHelloMapper;

    @GetMapping
    @RequestMapping("/hello/{id}")
    @ResponseBody
    public String test(@PathVariable("id") int id){

        THello tHello = new THello();
        tHello.setPk(id);
        return tHelloMapper.selectByPrimaryKey(tHello).toString();

    }


    @PostMapping
    @RequestMapping("/hello")
    public void post(){

        THello tHello = new THello();
        tHello.setCol1(String.valueOf(System.currentTimeMillis()));
        tHello.setCol2(String.valueOf(System.currentTimeMillis()));

        tHelloMapper.insert(tHello);
    }

    @PostMapping
    @RequestMapping("/test")
    public void filterAndInterceptor(){
        logger.debug("Filter and interceptor test!");
    }



}
