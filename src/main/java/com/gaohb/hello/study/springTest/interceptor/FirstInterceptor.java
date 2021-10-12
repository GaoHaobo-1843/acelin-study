package com.gaohb.hello.study.springTest.interceptor;

/*
 * 自定义拦截器
 * 1、实现Interceptor接口【HandlerInterceptor & MethodInterceptor】
 * 2、实现WebMvcConfigurer接口，在addInterceptors方法中将自定义拦截器进行注册
 **/

import com.gaohb.hello.study.config.base.Base;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Component
public class FirstInterceptor extends Base implements HandlerInterceptor {

    /**
     * 处理拦截之前执行
     * @return 根据实际业务需求 符合要求的才返回true 不符合的返回false
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        logger.info("FirstInterceptor ==> preHandle");
        String first = request.getParameter("first");
        if (Objects.equals(first, "acelin")) {
            return true;
        }
        response.setContentType("application/json,charset=utf-8");
        response.getOutputStream().write("不符合要求，不放行".getBytes(StandardCharsets.UTF_8));
        return false;
    }

    /**
     * 该方法仅在方法没有抛出异常且没有被拦截且执行成功的时候，才会进入执行
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {
        logger.info("FirstInterceptor ==> postHandle");
    }

    /**
     * 该方法无论方法是否抛出异常，只要没被拦截，最后都会进入执行
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {
        logger.info("FirstInterceptor ==> afterCompletion");
    }
    
}
