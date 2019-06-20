package com.gupb.core.service.impl;

import com.gupb.core.concurrent.threadlocal.TransactionContextLocal;
import com.gupb.core.concurrent.threadpool.TransactionContextPool;
import com.gupb.core.service.GupbMqSendReceiveService;
import com.gupb.core.service.GupbTransactionHandler;
import com.gupb.util.bean.context.GupbTransactionContext;
import com.gupb.util.entity.GupbTransaction;
import com.gupb.util.enums.GupbRoleEnum;
import com.gupb.util.enums.GupbStatusEnum;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Aspect
@Component
public class GupbImpl {

    @Autowired
    private GupbTransactionHandler gupbTransactionHandler;

    @Autowired
    private GupbMqSendReceiveService gupbMqSendReceiveService;

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
        GupbTransaction gupbTransaction = TransactionContextPool.getInstance().get();
        if (gupbTransaction == null) {
            gupbTransaction = buildMythTransaction(joinPoint, GupbRoleEnum.START.getCode(), GupbStatusEnum.BEGIN.getCode(), "");
            //设置tcc事务上下文，这个类会传递给远端
            GupbTransactionContext context = new GupbTransactionContext();
            //设置事务id
            context.setTransId(gupbTransaction.getTransId());
            //设置为发起者角色
            context.setRole(GupbRoleEnum.START.getCode());
            TransactionContextLocal.getInstance().set(context);
            TransactionContextPool.getInstance().set(gupbTransaction);
        }
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


    @AfterThrowing(value = "annotationPointCut()", throwing = "e")
    public void bind(JoinPoint joinPoint, Exception e) throws Throwable {
        System.out.println("异常【开始】");
        gupbMqSendReceiveService.handler(joinPoint);
        System.out.println("e：" + e.getMessage());
        System.out.println("异常【结束】");
    }

    private GupbTransaction buildMythTransaction(final JoinPoint point, final int role, final int status, final String transId) {
        GupbTransaction mythTransaction;
        if (StringUtils.isNotEmpty(transId)) {
            mythTransaction = new GupbTransaction(transId);
        } else {
            mythTransaction = new GupbTransaction();
        }
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Class<?> clazz = point.getTarget().getClass();
        mythTransaction.setStatus(status);
        mythTransaction.setRole(role);
        mythTransaction.setTargetClass(clazz.getName());
        mythTransaction.setTargetMethod(method.getName());
        return mythTransaction;
    }
}
