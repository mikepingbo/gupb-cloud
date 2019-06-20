package com.gupb.core.service.handler;

import com.gupb.annotation.Gupb;
import com.gupb.annotation.ModelTypeEnum;
import com.gupb.core.concurrent.threadlocal.TransactionContextLocal;
import com.gupb.core.concurrent.threadpool.TransactionContextPool;
import com.gupb.core.recketmq.GupbMqSendService;
import com.gupb.core.service.GupbMqSendReceiveService;
import com.gupb.core.service.GupbTransactionHandler;
import com.gupb.util.entity.GupbParticipant;
import com.gupb.util.entity.GupbTransaction;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;

/**
 * this gupb transaction actor.
 *
 * @author gupb(Gupb)
 */
@Component
public class ActorGupbSendMqHandler implements GupbMqSendReceiveService {

    /**
     * logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ActorGupbSendMqHandler.class);

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
        try {
            // 获取传入参数内容
            MethodSignature sign = (MethodSignature)joinPoint.getSignature();
            Method method = sign.getMethod();
            Gupb gupb = method.getAnnotation(Gupb.class);
            String destination = gupb.destination();
            ModelTypeEnum model = gupb.model();

            GupbTransaction gupbTransaction = TransactionContextPool.getInstance().get();
            if ("service".equals(model.getDesc())) {
                TransactionContextPool.getInstance().remove();
                TransactionContextLocal.getInstance().remove();
            } else if (gupbTransaction != null && gupbTransaction.getGupbParticipants() != null) {
                List<GupbParticipant> gupbParticipants = gupbTransaction.getGupbParticipants();
                for (GupbParticipant gupbParticipant : gupbParticipants) {
                    if (destination.equals(gupbParticipant.getDestination())) {
                        gupbParticipant.setSendFlag(0);
                    }
                }
                System.out.println(gupbTransaction);
            }
        } catch (Throwable throwable) {
            throw throwable;
        } finally {
//            TransactionContextPool.getInstance().remove();
        }
    }
}
