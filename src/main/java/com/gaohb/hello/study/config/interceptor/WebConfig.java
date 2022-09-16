package com.gaohb.hello.study.config.interceptor;

import com.gaohb.hello.study.springTest.interceptor.FirstInterceptor;
import com.gaohb.hello.study.springTest.interceptor.SecondInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private FirstInterceptor firstInterceptor;
    @Autowired
    private SecondInterceptor secondInterceptor;

    /**
     * 拦截器注册 可注册多个 执行顺序和注册顺序一样
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

//        /* 注册，拦截器的执行顺序取决与注册顺序 */
//        registry.addInterceptor(firstInterceptor)
//                .addPathPatterns("/**") //设置会被该拦截器拦截的请求路径  /** 表示所有
//                .excludePathPatterns("/mybatis/test"); //设置该拦截器不会拦截的请求路径
//        registry.addInterceptor(secondInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/mybatis/hello"); //设置该拦截器不会拦截的请求路径
    }

}
