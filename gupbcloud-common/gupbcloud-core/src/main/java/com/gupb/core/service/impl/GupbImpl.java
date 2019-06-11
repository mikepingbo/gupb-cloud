package com.gupb.core.service.impl;

import com.gupb.core.service.GupbTransactionHandler;
import com.gupb.util.IdWorkerUtils;
import com.gupb.util.mq.MessageEntity;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class GupbImpl {

    @Autowired
    private GupbTransactionHandler gupbTransactionHandler;

    /**
     * 定义切入点
     */
    @Pointcut("@annotation(com.gupb.annotation.Gupb)")
    public void annotationPointCut() {

    }

    /**
     * before
     * 
     * @param joinPoint
     */
    @Before("annotationPointCut()")
    public void befor(JoinPoint joinPoint) throws Exception {
        System.out.println("拦截器进入方法之前执行");
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setTransId(IdWorkerUtils.getInstance().createUUID());
    }

    /**
     * after
     *
     * @param joinPoint
     * @throws Exception
     */
    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint) throws Throwable {
        System.out.println("拦截器进入方法之后执行");
        gupbTransactionHandler.handler(joinPoint);
    }
}
