package com.gupb.admin.feign;

import com.gupb.admin.feign.hystrix.TestFeignHystrix;
import com.gupb.feign.FeignConfig;
import com.gupb.page.WrapMapperResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "gupbcloud-admin", configuration = FeignConfig.class, fallback = TestFeignHystrix.class)
public interface TestFeignApi {

    @RequestMapping(value = "/api/test", method = RequestMethod.GET)
    WrapMapperResult<Object> admintest(@RequestParam("message") String message);
}
