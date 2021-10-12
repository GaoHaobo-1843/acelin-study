package com.gaohb.hello.study.springTest.filter;


import com.gaohb.hello.study.config.base.Base;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/*
 * 过滤器实现
 * 1、实现 Filter 接口；
 * 2、通过@WebFilter注解完成过滤路径设置
 **/

@Component
@WebFilter(urlPatterns = {"/mybatis/hello"}) // 设置会被过滤处理的路请求径
@Order(0)   // 设置过滤器的优先级，值越小优先级越高，doFilter()越早执行
public class SecondFilter extends Base implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
        logger.info("Second Filter ==> init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("Second Filter ==> doFilter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("Second Filter ==> destroy");
    }
}
