package com.gupb.account.controller.frontend;

import com.gupb.util.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("Account服务口类")
@RestController
public class AccountController extends BaseController {

    @PostMapping(value = "/test")
    @ApiOperation(value = "测试接口")
    public String test() {
        return "sucess";
    }

}
