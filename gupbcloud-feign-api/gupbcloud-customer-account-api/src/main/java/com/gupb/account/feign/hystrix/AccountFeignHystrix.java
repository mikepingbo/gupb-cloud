package com.gupb.account.feign.hystrix;

import com.gupb.account.api.dto.AccountDTO;
import com.gupb.account.api.entity.AccountDO;
import com.gupb.account.feign.AccountFeignApi;
import com.gupb.util.page.WrapMapperResult;
import com.gupb.util.page.WrapMapperUtil;
import org.springframework.stereotype.Component;

@Component
public class AccountFeignHystrix implements AccountFeignApi {

    @Override
    public WrapMapperResult<Boolean> payment(AccountDTO accountDO) {
        return WrapMapperUtil.failBiz("Feign请求Account服务失败");
    }

    @Override
    public WrapMapperResult<AccountDO> findByUserId(String userId) {
        return WrapMapperUtil.failBiz("Feign请求Account服务失败");
    }
}
