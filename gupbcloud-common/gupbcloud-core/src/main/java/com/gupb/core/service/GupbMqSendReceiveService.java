package com.gupb.core.service;

import com.gupb.util.bean.context.GupbTransactionContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * GupbTransactionHandler.
 *
 * @author gupb
 */
@FunctionalInterface
public interface GupbMqSendReceiveService {

    /**
     * GupbTransactionHandler.
     *
     * @param joinPoint                  joinPoint
     * @return Object
     * @throws Throwable ex
     */
    void handler(JoinPoint joinPoint) throws Throwable;
}
