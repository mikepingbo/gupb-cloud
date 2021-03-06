package com.gupb.account.controller.rpc;

import com.gupb.account.api.dto.AccountDTO;
import com.gupb.account.api.entity.AccountDO;
import com.gupb.account.feign.AccountFeignApi;
import com.gupb.account.api.service.AccountService;
import com.gupb.util.base.BaseController;
import com.gupb.util.page.WrapMapperResult;
import com.gupb.util.page.WrapMapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api(value = "Account服务Feign接口API")
@RefreshScope
@RestController
public class AccountFeignClient extends BaseController implements AccountFeignApi {

    @Autowired
    private AccountService accountService;

    @Autowired
    private HttpServletRequest servletRequest;

    @Override
    @ApiOperation(value = "支付API", notes = "支付API")
    public WrapMapperResult<Boolean> payment(AccountDTO accountDO) {
        Boolean result = accountService.payment(accountDO);
        System.out.println(servletRequest.getHeader("token"));
        System.out.println(servletRequest.getHeader("Cookie"));
        System.out.println(servletRequest.getHeader("GUPB_TRANSACTION_CONTEXT"));

        return WrapMapperUtil.success(result);
    }

    @Override
    @ApiOperation(value = "查询账户信息API", notes = "查询账户信息API")
    public WrapMapperResult<AccountDO> findByUserId(String userId) {
        AccountDO accountDO = accountService.findByUserId(userId);
        System.out.println(servletRequest.getHeader("token"));
        System.out.println(servletRequest.getHeader("Cookie"));

        return WrapMapperUtil.success(accountDO);
    }
}
