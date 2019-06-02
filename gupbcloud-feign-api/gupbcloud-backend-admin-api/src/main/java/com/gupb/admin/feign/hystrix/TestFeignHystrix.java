package com.gupb.admin.feign.hystrix;

import com.gupb.admin.feign.TestFeignApi;
import com.gupb.page.WrapMapperResult;
import com.gupb.page.WrapMapperUtil;
import org.springframework.stereotype.Component;

@Component
public class TestFeignHystrix implements TestFeignApi {

    @Override
    public WrapMapperResult<Object> admintest(String message) {
        return WrapMapperUtil.failBiz("Feign请求Admin服务失败");
    }
}
