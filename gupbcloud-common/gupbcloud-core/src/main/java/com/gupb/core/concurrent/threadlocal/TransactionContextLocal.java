package com.gupb.core.concurrent.threadlocal;


import com.gupb.util.entity.GupbInvocation;

/**
 * TransactionContextLocal.
 *
 * @author gupb
 */
public final class TransactionContextLocal {

    private static final ThreadLocal<GupbInvocation> CURRENT_LOCAL = new ThreadLocal<>();

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
    public void set(final GupbInvocation context) {
        CURRENT_LOCAL.set(context);
    }

    /**
     * Get gupb transaction context.
     *
     * @return the gupb transaction context
     */
    public GupbInvocation get() {
        return CURRENT_LOCAL.get();
    }

    /**
     * Remove.
     */
    public void remove() {
        CURRENT_LOCAL.remove();
    }
}
