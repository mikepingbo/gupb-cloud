package com.gupb.admin.controller.frontend;

import com.gupb.base.BaseController;
import com.gupb.page.WrapMapperResult;
import com.gupb.page.WrapMapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("Admin服务测试接口类")
@RestController
public class TestController extends BaseController{

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ApiOperation(value = "测试API", notes = "测试API")
    public WrapMapperResult<Object> test(String message) {
        return WrapMapperUtil.success("这是Admin服务的一个测试接口,参数为： " + message);
    }
}
