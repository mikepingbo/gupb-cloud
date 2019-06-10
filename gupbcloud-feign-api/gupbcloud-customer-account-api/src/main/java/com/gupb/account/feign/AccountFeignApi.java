package com.gupb.account.feign;

import com.gupb.account.api.dto.AccountDTO;
import com.gupb.account.api.entity.AccountDO;
import com.gupb.account.api.service.AccountService;
import com.gupb.account.feign.hystrix.AccountFeignHystrix;
import com.gupb.annotation.Gupb;
import com.gupb.util.feign.FeignConfig;
import com.gupb.util.page.WrapMapperResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "gupbcloud-account", configuration = FeignConfig.class, fallback = AccountFeignHystrix.class)
public interface AccountFeignApi {

    @Gupb(destination = "account, account", target = AccountService.class)
    @RequestMapping(value = "/account/payment", method = RequestMethod.POST)
    WrapMapperResult<Boolean> payment(@RequestBody AccountDTO accountDO);

    @RequestMapping(value = "/account/findbyuserid", method = RequestMethod.GET)
    WrapMapperResult<AccountDO> findByUserId(@RequestParam("userId") String userId);

}
