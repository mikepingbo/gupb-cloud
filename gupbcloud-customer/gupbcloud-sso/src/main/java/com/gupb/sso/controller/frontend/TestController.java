package com.gupb.sso.controller.frontend;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(value = "/test2")
    public String test2() {
        return "sucess";
    }
}