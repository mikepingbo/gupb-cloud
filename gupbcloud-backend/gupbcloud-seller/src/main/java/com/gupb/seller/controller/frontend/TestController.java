package com.gupb.seller.controller.frontend;

import com.gupb.admin.feign.TestFeignApi;
import com.gupb.base.BaseController;
import com.gupb.page.WrapMapperResult;
import com.gupb.page.WrapMapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api("Seller服务测试接口类")
@RestController
public class TestController extends BaseController{

    @Resource
    private TestFeignApi testFeignApi;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ApiOperation(value = "测试API", notes = "测试API")
    public WrapMapperResult<Object> test(String message) {
        return WrapMapperUtil.success("这是Seller服务的一个测试接口,参数为：" + message);
    }

    @RequestMapping(value = "/feign/test", method = RequestMethod.GET)
    @ApiOperation(value = "调用Admin服务测试API", notes = "调用Admin服务测试API")
    public WrapMapperResult<Object> admintest(String message) {
        WrapMapperResult<Object> result = testFeignApi.admintest("我来自seller服务,参数为：" + message);
        return result;
    }
}
