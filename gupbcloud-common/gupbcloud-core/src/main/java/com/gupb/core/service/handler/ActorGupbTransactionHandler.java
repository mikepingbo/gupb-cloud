package com.gupb.core.service.handler;

import com.gupb.annotation.Gupb;
import com.gupb.annotation.ModelTypeEnum;
import com.gupb.core.concurrent.threadlocal.TransactionContextLocal;
import com.gupb.core.concurrent.threadpool.TransactionContextPool;
import com.gupb.core.recketmq.GupbMqSendService;
import com.gupb.core.service.GupbTransactionHandler;
import com.gupb.util.entity.GupbInvocation;
import com.gupb.util.entity.GupbParticipant;
import com.gupb.util.entity.GupbTransaction;
import com.gupb.util.serializer.MainSerializer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.List;

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

    /**
     * save GupbTransaction in threadLocal.
     */
    private static final ThreadLocal<GupbTransaction> CURRENT = new ThreadLocal<>();

    @Autowired
    private GupbMqSendService gupbMqSendService;

    private GupbTransaction getCurrentTransaction() {
        return CURRENT.get();
    }

    @Override
    public void handler(JoinPoint joinPoint) throws Throwable {
        ModelTypeEnum model = null;
        try {
            // 获取传入参数内容
            MethodSignature sign = (MethodSignature)joinPoint.getSignature();
            Method method = sign.getMethod();
            Gupb gupb = method.getAnnotation(Gupb.class);
            model = gupb.model();
            GupbTransaction gupbTransaction = TransactionContextPool.getInstance().get();

            if ("service".equals(model.getDesc()) && gupbTransaction != null && gupbTransaction.getGupbParticipants() != null) {
                List<GupbParticipant> gupbParticipants = gupbTransaction.getGupbParticipants();
                for (GupbParticipant gupbParticipant : gupbParticipants) {
                    if (gupbParticipant.getSendFlag() == 0) {
                        String sendDestination = gupbParticipant.getDestination();
                        final byte[] message = MainSerializer.toByteArray(gupbParticipant);
                        // TODO 发送MQ逻辑先简单写一下，需要考虑高并发情况
                        // TODO 需要考虑方式失败，需要持久化处理
                        gupbMqSendService.sendMessage(sendDestination, null, message);
                    }
                }
            }
        } catch (Throwable throwable) {
            throw throwable;
        } finally {
            if ("service".equals(model.getDesc())) {
                TransactionContextLocal.getInstance().remove();
                TransactionContextPool.getInstance().remove();
            }
        }
    }
}
