package com.gupb.core.mediator;

/**
 * The interface Rpc acquire.
 *
 * @author gupb(Gupb)
 */
public interface RpcAcquire {

    /**
     * Acquire string.
     *
     * @param key the key
     * @return the string
     */
    String acquire(String key);
}
