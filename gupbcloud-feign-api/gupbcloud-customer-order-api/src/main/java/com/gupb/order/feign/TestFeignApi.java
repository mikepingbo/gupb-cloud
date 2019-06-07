package com.gupb.order.feign;

import com.gupb.order.feign.hystrix.TestFeignHystrix;
import com.gupb.util.feign.FeignConfig;
import com.gupb.util.page.WrapMapperResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "gupbcloud-order", configuration = FeignConfig.class, fallback = TestFeignHystrix.class)
public interface TestFeignApi {

    @RequestMapping(value = "/api/test", method = RequestMethod.GET)
    WrapMapperResult<Object> admintest(@RequestParam("message") String message);
}
