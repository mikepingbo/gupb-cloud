package com.gupb.core.concurrent.threadpool;


import com.gupb.util.entity.GupbParticipant;
import com.gupb.util.entity.GupbTransaction;

/**
 * TransactionContextPool.
 *
 * @author gupb
 */
public final class TransactionContextPool {

    private static final ThreadLocal<GupbTransaction> CURRENT_LOCAL = new ThreadLocal<>();

    private static final TransactionContextPool TRANSACTION_CONTEXT_LOCAL = new TransactionContextPool();

    private TransactionContextPool() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static TransactionContextPool getInstance() {
        return TRANSACTION_CONTEXT_LOCAL;
    }

    /**
     * Set.
     *
     * @param context the context
     */
    public void set(final GupbTransaction context) {
        CURRENT_LOCAL.set(context);
    }

    /**
     * Get gupb transaction context.
     *
     * @return the gupb transaction context
     */
    public GupbTransaction get() {
        return CURRENT_LOCAL.get();
    }

    /**
     * Remove.
     */
    public void remove() {
        CURRENT_LOCAL.remove();
    }
}
