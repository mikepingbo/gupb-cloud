package com.gupb.recketmq.service;

import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.google.common.base.Splitter;
import com.gupb.core.recketmq.GupbMqSendService;
import com.gupb.util.LogUtil;
import com.gupb.util.constant.CommonConstant;
import com.gupb.util.exception.GupbRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.rocketmq.common.message.Message;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RocketmqSendServiceImpl implements GupbMqSendService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RocketmqSendServiceImpl.class);

    @Autowired
    private DefaultMQProducer defaultMQProducer;

    @Override
    public void sendMessage(final String destination, final Integer pattern, final byte[] message) {
        try {
            Message msg;
            List<String> stringList = Splitter.on(CommonConstant.TOPIC_TAG_SEPARATOR).trimResults().splitToList(destination);
            if (stringList.size() > 1) {
                String topic = stringList.get(0);
                String tags = stringList.get(1);
                msg = new Message(topic, tags, message);
            } else {
                msg = new Message(destination, "", message);
            }
            final SendResult sendResult = defaultMQProducer.send(msg);
            LogUtil.info(LOGGER, sendResult::toString);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.error(LOGGER, e::getMessage);
            throw new GupbRuntimeException();
        }
    }
}
