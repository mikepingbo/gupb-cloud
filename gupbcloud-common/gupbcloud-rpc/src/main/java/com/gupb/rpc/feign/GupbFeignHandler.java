package com.gupb.rpc.feign;

import com.gupb.annotation.Gupb;
import com.gupb.core.concurrent.threadlocal.TransactionContextLocal;
import com.gupb.core.concurrent.threadpool.TransactionContextPool;
import com.gupb.core.helper.SpringBeanUtils;
import com.gupb.util.DefaultValueUtils;
import com.gupb.util.bean.context.GupbTransactionContext;
import com.gupb.util.entity.GupbInvocation;
import com.gupb.util.entity.GupbParticipant;
import com.gupb.util.entity.GupbTransaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * GupbFeignHandler.
 *
 * @author gupb
 */
public class GupbFeignHandler implements InvocationHandler {

    private InvocationHandler delegate;

    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        } else {
            final Gupb gupb = method.getAnnotation(Gupb.class);
            if (Objects.isNull(gupb)) {
                return this.delegate.invoke(proxy, method, args);
            }
            try {
                final GupbParticipant participant = buildParticipant(gupb, method, args);
                if (Objects.nonNull(participant)) {
                    GupbTransaction gupbTransaction = TransactionContextPool.getInstance().get();
                    gupbTransaction.registerParticipant(participant);
                }

                return this.delegate.invoke(proxy, method, args);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
                return DefaultValueUtils.getDefaultValue(method.getReturnType());
            }
        }
    }

    private GupbParticipant buildParticipant(final Gupb gupb, final Method method, final Object[] args) {
        final GupbTransactionContext gupbTransactionContext = TransactionContextLocal.getInstance().get();

        GupbParticipant participant;
        if (Objects.nonNull(gupbTransactionContext)) {
            final Class declaringClass = gupb.target();
            GupbInvocation mythInvocation =
                    new GupbInvocation(declaringClass, method.getName(), method.getParameterTypes(), args);
            final Integer pattern = gupb.pattern().getCode();
            //封装调用点
            participant = new GupbParticipant(gupbTransactionContext.getTransId(),
                    gupb.destination(),
                    pattern,
                    1,
                    mythInvocation);
            return participant;
        }

        return null;
    }

    public void setDelegate(InvocationHandler delegate) {
        this.delegate = delegate;
    }
}
