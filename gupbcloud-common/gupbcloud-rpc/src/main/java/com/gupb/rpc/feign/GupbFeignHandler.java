package com.gupb.rpc.feign;

import com.gupb.annotation.Gupb;
import com.gupb.core.concurrent.threadlocal.TransactionContextLocal;
import com.gupb.util.DefaultValueUtils;
import com.gupb.util.entity.GupbInvocation;

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
                final GupbInvocation participant = buildParticipant(gupb, method, args);
                TransactionContextLocal.getInstance().set(participant);

                return this.delegate.invoke(proxy, method, args);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
                return DefaultValueUtils.getDefaultValue(method.getReturnType());
            }
        }
    }

    private GupbInvocation buildParticipant(final Gupb gupb, final Method method, final Object[] args) {
        final Class declaringClass = gupb.target();
        GupbInvocation gupbInvocation =
                new GupbInvocation(declaringClass, method.getName(), method.getParameterTypes(), args);

        return gupbInvocation;
    }

    public void setDelegate(InvocationHandler delegate) {
        this.delegate = delegate;
    }
}
