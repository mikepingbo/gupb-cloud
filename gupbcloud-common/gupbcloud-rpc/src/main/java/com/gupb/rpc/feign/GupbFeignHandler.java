package com.gupb.rpc.feign;

import com.gupb.annotation.Gupb;
import com.gupb.core.concurrent.threadlocal.TransactionContextLocal;
import com.gupb.core.recketmq.GupbMqSendService;
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

    private GupbMqSendService gupbMqSendService;

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

                final Class targetClass = gupb.target();
                final String methodName = method.getName();
                final Class[] parameterTypes = method.getParameterTypes();

                // TODO 简单处理，需要提取出去
                GupbInvocation gupbInvocation = new GupbInvocation();
                gupbInvocation.setTargetClass(targetClass);
                gupbInvocation.setMethodName(methodName);
                gupbInvocation.setParameterTypes(parameterTypes);
                gupbInvocation.setArgs(args);

                TransactionContextLocal.getInstance().set(gupbInvocation);

                return this.delegate.invoke(proxy, method, args);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
                // TODO 返回默认值未处理
//                return DefaultValueUtils.getDefaultValue(method.getReturnType());

                return null;
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
