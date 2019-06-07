package com.gupb.annotation.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GupbImpl {

    /**
     * 定义切入点
     */
    @Pointcut("@annotation(com.gupb.annotation.Gupb)")
    public void annotationPointCut() {

    }

    /**
     * AOP before切面 </br> 用户端访问切面
     * 
     * @param joinPoint
     */
    @Before("annotationPointCut()")
    public void befor(JoinPoint joinPoint) throws Exception {
        System.out.println("拦截器进入方法之前执行");
    }

    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint) throws Exception {
        System.out.println("拦截器进入方法之后执行");
    }
}
