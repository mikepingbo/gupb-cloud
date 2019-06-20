package com.gupb.rpc.feign;

import com.gupb.core.concurrent.threadlocal.TransactionContextLocal;
import com.gupb.core.mediator.RpcMediator;
import com.gupb.util.bean.context.GupbTransactionContext;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

/**
 * GupbFeignInterceptor.
 *
 * @author gupb
 */
@Configuration
public class GupbFeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(final RequestTemplate requestTemplate) {
        final GupbTransactionContext mythTransactionContext = TransactionContextLocal.getInstance().get();
        RpcMediator.getInstance().transmit(requestTemplate::header, mythTransactionContext);
    }

}
