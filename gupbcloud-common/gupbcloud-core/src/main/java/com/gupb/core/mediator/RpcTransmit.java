package com.gupb.core.mediator;

/**
 * The interface Rpc mediator.
 *
 * @author gupb(Gupb)
 */
public interface RpcTransmit {

    /**
     * Transmit.
     *
     * @param key   the key
     * @param value the value
     */
    void transmit(String key, String value);

}
