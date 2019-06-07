package com.gupb.core.recketmq;

@FunctionalInterface
public interface GupbMqSendService {

    /**
     * send message.
     *
     * @param destination
     * @param pattern
     * @param message
     */
    void sendMessage(String destination, Integer pattern, byte[] message);

}
