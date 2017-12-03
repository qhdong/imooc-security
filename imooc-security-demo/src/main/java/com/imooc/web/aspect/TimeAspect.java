package com.imooc.web.aspect;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Aspect
@Component
public class TimeAspect {

     @Around("execution(* com.imooc.web.controller.UserController.*(..))")
     public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {

         log.info("time aspect start");

         Object[] args = pjp.getArgs();
         log.info(ReflectionToStringBuilder.toString(args, ToStringStyle.MULTI_LINE_STYLE));

         long start = new Date().getTime();
         Object result = pjp.proceed();
         log.info("方法耗时：{}", (new Date().getTime() - start));

         log.info("time aspect end");

         return result;
     }
}
