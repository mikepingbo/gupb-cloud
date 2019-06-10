package com.gupb.core;

import java.io.IOException;

/**
 * process receive mq info .
 *
 * @author gupb
 */
@FunctionalInterface
public interface GupbMqReceiveService {

    /**
     * process receive mq info .
     *
     * @param message byte[] message
     * @return true success
     */
    Boolean processMessage(byte[] message) throws IOException;
}
