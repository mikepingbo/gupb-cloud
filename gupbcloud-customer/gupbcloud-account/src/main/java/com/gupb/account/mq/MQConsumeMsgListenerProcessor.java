package com.gupb.account.mq;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.gupb.core.helper.SpringBeanUtils;
import com.gupb.util.entity.GupbInvocation;
import com.gupb.util.serializer.MainSerializer;
import org.apache.commons.lang.reflect.MethodUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Component
public class MQConsumeMsgListenerProcessor implements MessageListenerConcurrently{
    private static final Logger logger = LoggerFactory.getLogger(MQConsumeMsgListenerProcessor.class);

    /**
     *  默认msgs里只有一条消息，可以通过设置consumeMessageBatchMaxSize参数来批量接收消息<br/>
     *  不要抛异常，如果没有return CONSUME_SUCCESS ，consumer会重新消费该消息，直到return CONSUME_SUCCESS
     */
    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        if(CollectionUtils.isEmpty(msgs)){
            logger.info("接受到的消息为空，不处理，直接返回成功");
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
        MessageExt messageExt = msgs.get(0);
        logger.info("接受到的消息为："+messageExt.toString());
        if(messageExt.getTopic().equals("account")){
            if(messageExt.getTags().equals("account")){
                //TODO 判断该消息是否重复消费（RocketMQ不保证消息不重复，如果你的业务需要保证严格的不重复消息，需要你自己在业务端去重）
                //TODO 获取该消息重试次数
                int reconsume = messageExt.getReconsumeTimes();
                if(reconsume ==3){
                    // TODO 代码可以根据业务修改
                    //消息已经重试了3次，如果不需要再次消费，则返回成功
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }

                // TODO 以下代码需要提出去
                final byte[] message = messageExt.getBody();
                GupbInvocation gupbInvocation = (GupbInvocation) MainSerializer.checkObject(message);
                final Class clazz = gupbInvocation.getTargetClass();
                final String method = gupbInvocation.getMethodName();
                final Object[] args = gupbInvocation.getArgs();
                final Class[] parameterTypes = gupbInvocation.getParameterTypes();
                final Object bean = SpringBeanUtils.getInstance().getBean(clazz);

                //TODO 处理对应的业务逻辑
                try {
                    MethodUtils.invokeMethod(bean, method, args, parameterTypes);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        // 如果没有return success ，consumer会重新消费该消息，直到return success
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}