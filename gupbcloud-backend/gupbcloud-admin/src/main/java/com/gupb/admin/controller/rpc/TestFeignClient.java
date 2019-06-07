package com.gupb.admin.controller.rpc;

import com.gupb.admin.feign.TestFeignApi;
import com.gupb.util.base.BaseController;
import com.gupb.util.page.WrapMapperResult;
import com.gupb.util.page.WrapMapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@Api(value = "Admin服务Feign接口API")
public class TestFeignClient extends BaseController implements TestFeignApi {

    @Override
    @ApiOperation(value = "Feign测试API", notes = "Feign测试API")
    public WrapMapperResult<Object> admintest(String message) {
        return WrapMapperUtil.success("这是Admin服务的一个Feign测试接口,参数为： " + message);
    }
}
