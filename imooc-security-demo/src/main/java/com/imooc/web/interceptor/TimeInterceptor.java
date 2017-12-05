package com.imooc.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Slf4j
//@Component
public class TimeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        log.info("time interceptor preHandle");
        log.info("Class name: {}", ((HandlerMethod)o).getBean().getClass().getName());
        log.info("Method name: {}", ((HandlerMethod)o).getMethod().getName());

        httpServletRequest.setAttribute("startTime", new Date().getTime());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        log.info("time interceptor postHandle");
        long start = (long) httpServletRequest.getAttribute("startTime");
        log.info("time interceptor 请求耗时: {}", new Date().getTime() - start);
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        log.info("time interceptor afterCompletion");
        long start = (long) httpServletRequest.getAttribute("startTime");
        log.info("time interceptor 请求耗时: {}", new Date().getTime() - start);
        log.info("exception: {}", e);
    }
}
