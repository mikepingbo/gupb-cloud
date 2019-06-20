package com.gupb.core.concurrent.threadlocal;


import com.gupb.util.bean.context.GupbTransactionContext;

/**
 * TransactionContextLocal.
 *
 * @author gupb
 */
public final class TransactionContextLocal {

    private static final ThreadLocal<GupbTransactionContext> CURRENT_LOCAL = new ThreadLocal<>();

    private static final TransactionContextLocal TRANSACTION_CONTEXT_LOCAL = new TransactionContextLocal();

    private TransactionContextLocal() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static TransactionContextLocal getInstance() {
        return TRANSACTION_CONTEXT_LOCAL;
    }

    /**
     * Set.
     *
     * @param context the context
     */
    public void set(final GupbTransactionContext context) {
        CURRENT_LOCAL.set(context);
    }

    /**
     * Get gupb transaction context.
     *
     * @return the gupb transaction context
     */
    public GupbTransactionContext get() {
        return CURRENT_LOCAL.get();
    }

    /**
     * Remove.
     */
    public void remove() {
        CURRENT_LOCAL.remove();
    }
}
