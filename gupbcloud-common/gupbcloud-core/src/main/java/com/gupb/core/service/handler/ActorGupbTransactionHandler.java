package com.gupb.core.service.handler;

import com.gupb.annotation.Gupb;
import com.gupb.core.concurrent.threadlocal.TransactionContextLocal;
import com.gupb.core.recketmq.GupbMqSendService;
import com.gupb.core.service.GupbTransactionHandler;
import com.gupb.util.entity.GupbInvocation;
import com.gupb.util.serializer.MainSerializer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * this gupb transaction actor.
 *
 * @author gupb(Gupb)
 */
@Component
public class ActorGupbTransactionHandler implements GupbTransactionHandler {

    /**
     * logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ActorGupbTransactionHandler.class);

    @Autowired
    private GupbMqSendService gupbMqSendService;

    @Override
    public void handler(JoinPoint joinPoint) throws Throwable {
        try {
            // 获取传入参数内容
            MethodSignature sign = (MethodSignature)joinPoint.getSignature();
            Method method = sign.getMethod();
            Gupb gupb = method.getAnnotation(Gupb.class);
            String destination = gupb.destination();
            final GupbInvocation gupbInvocation = TransactionContextLocal.getInstance().get();
            final byte[] message = MainSerializer.toByteArray(gupbInvocation);

            // TODO 发送MQ逻辑先简单写一下，需要考虑高并发情况
            gupbMqSendService.sendMessage(destination, null, message);
        } catch (Throwable throwable) {
            throw throwable;
        } finally {
            TransactionContextLocal.getInstance().remove();
        }
    }
}
