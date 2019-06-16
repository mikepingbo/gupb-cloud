package com.gupb.gateway.fallback;

import com.gupb.util.page.WrapMapperResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBack {

    @GetMapping("/fallback")
    public WrapMapperResult fallback() {
        // TODO 熔断类型怎么判断？
        WrapMapperResult response = new WrapMapperResult();
        response.setCode("100");
        response.setMessage("服务暂时不可用");
        return response;
    }
}
