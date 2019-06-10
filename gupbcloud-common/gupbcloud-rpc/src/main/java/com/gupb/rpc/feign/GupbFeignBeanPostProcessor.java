package com.gupb.rpc.feign;

import com.gupb.annotation.Gupb;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;

/**
 * The type Gupb feign bean post processor.
 *
 * @author gupb(Gupb)
 */
public class GupbFeignBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(final Object bean, final String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, final String beanName) throws BeansException {
        if (!Proxy.isProxyClass(bean.getClass())) {
            return bean;
        }
        InvocationHandler handler = Proxy.getInvocationHandler(bean);

        final Method[] methods = ReflectionUtils.getAllDeclaredMethods(bean.getClass());

        for (Method method : methods) {
            Gupb gupb = AnnotationUtils.findAnnotation(method, Gupb.class);
            if (Objects.nonNull(gupb)) {
                GupbFeignHandler gupbFeignHandler = new GupbFeignHandler();
                gupbFeignHandler.setDelegate(handler);
                Class<?> clazz = bean.getClass();
                Class<?>[] interfaces = clazz.getInterfaces();
                ClassLoader loader = clazz.getClassLoader();
                return Proxy.newProxyInstance(loader, interfaces, gupbFeignHandler);
            }
        }
        return bean;
    }

}


