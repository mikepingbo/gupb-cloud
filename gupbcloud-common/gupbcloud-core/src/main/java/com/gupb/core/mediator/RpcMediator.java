package com.gupb.core.mediator;


import com.gupb.util.bean.context.GupbTransactionContext;
import com.gupb.util.constant.CommonConstant;
import com.gupb.util.json.GsonUtils;
import org.apache.commons.lang.StringUtils;

/**
 * The type RpcMediator.
 *
 * @author xiaoyu(Myth)
 */
public class RpcMediator {

    private static final RpcMediator RPC_MEDIATOR = new RpcMediator();

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static RpcMediator getInstance() {
        return RPC_MEDIATOR;
    }


    /**
     * Transmit.
     *
     * @param rpcTransmit the rpc mediator
     * @param context     the context
     */
    public void transmit(final RpcTransmit rpcTransmit, final GupbTransactionContext context) {
        rpcTransmit.transmit(CommonConstant.GUPB_TRANSACTION_CONTEXT,
                GsonUtils.getInstance().toJson(context));
    }

    /**
     * Acquire hmily transaction context.
     *
     * @param rpcAcquire the rpc acquire
     * @return the hmily transaction context
     */
    public GupbTransactionContext acquire(RpcAcquire rpcAcquire) {
        GupbTransactionContext mythTransactionContext = null;
        final String context = rpcAcquire.acquire(CommonConstant.GUPB_TRANSACTION_CONTEXT);
        if (StringUtils.isNotEmpty(context)) {
            mythTransactionContext = GsonUtils.getInstance().fromJson(context, GupbTransactionContext.class);
        }
        return mythTransactionContext;
    }
}
