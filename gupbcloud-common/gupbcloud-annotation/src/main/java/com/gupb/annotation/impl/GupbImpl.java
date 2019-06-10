package com.gupb.annotation.impl;

import com.gupb.annotation.Gupb;
import com.gupb.core.concurrent.threadlocal.TransactionContextLocal;
import com.gupb.core.recketmq.GupbMqSendService;
import com.gupb.util.IdWorkerUtils;
import com.gupb.util.entity.GupbInvocation;
import com.gupb.util.mq.MessageEntity;
import com.gupb.util.serializer.MainSerializer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class GupbImpl {

    @Autowired
    private GupbMqSendService gupbMqSendService;

    /**
     * 定义切入点
     */
    @Pointcut("@annotation(com.gupb.annotation.Gupb)")
    public void annotationPointCut() {

    }

    /**
     * AOP before切面
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
     * after切面
     *
     * @param joinPoint
     * @throws Exception
     */
    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint) throws Exception {
        // 获取传入参数内容
        MethodSignature sign = (MethodSignature)joinPoint.getSignature();
        Method method = sign.getMethod();
        Gupb gupb = method.getAnnotation(Gupb.class);

        System.out.println("拦截器进入方法之后执行");
        String destination = gupb.destination();
        final GupbInvocation gupbInvocation = TransactionContextLocal.getInstance().get();
        final byte[] message = MainSerializer.toByteArray(gupbInvocation);

        // TODO 发送MQ逻辑先简单写一下，需要考虑高并发情况
        gupbMqSendService.sendMessage(destination, null, message);

        // TODO 简单处理一下，需要修改成try catch finally
        TransactionContextLocal.getInstance().remove();
    }
}
