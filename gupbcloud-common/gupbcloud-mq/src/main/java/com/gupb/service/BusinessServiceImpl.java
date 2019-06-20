package com.gupb.service;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.gupb.core.helper.SpringBeanUtils;
import com.gupb.util.entity.GupbInvocation;
import com.gupb.util.entity.GupbParticipant;
import com.gupb.util.serializer.MainSerializer;
import org.apache.commons.lang.reflect.MethodUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

@Service
public class BusinessServiceImpl implements BusinessService {

    public ConsumeConcurrentlyStatus checkMqBody(MessageExt messageExt) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        //TODO 判断该消息是否重复消费（RocketMQ不保证消息不重复，如果你的业务需要保证严格的不重复消息，需要你自己在业务端去重）
        //TODO 获取该消息重试次数
        int reconsume = messageExt.getReconsumeTimes();
        if(reconsume ==3) {
            // TODO 代码可以根据业务修改
            //消息已经重试了3次，如果不需要再次消费，则返回成功
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }

        // TODO 以下代码需要提出去
        final byte[] message = messageExt.getBody();
        GupbParticipant gupbParticipant = (GupbParticipant) MainSerializer.checkObject(message);

        GupbInvocation gupbInvocation = null;
        if (gupbParticipant != null && gupbParticipant.getGupbInvocation() != null) {
            gupbInvocation = gupbParticipant.getGupbInvocation();
        }

        if (gupbInvocation != null) {
            final Class clazz = gupbInvocation.getTargetClass();
            final String method = gupbInvocation.getMethodName();
            final Object[] args = gupbInvocation.getArgs();
            final Class[] parameterTypes = gupbInvocation.getParameterTypes();
            final Object bean = SpringBeanUtils.getInstance().getBean(clazz);

            MethodUtils.invokeMethod(bean, method, args, parameterTypes);
        }

        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}