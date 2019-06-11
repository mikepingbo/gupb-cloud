package com.gupb.service;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.common.message.MessageExt;

import java.lang.reflect.InvocationTargetException;

@FunctionalInterface
public interface BusinessService {

    ConsumeConcurrentlyStatus checkMqBody(MessageExt messageExt) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;
}
