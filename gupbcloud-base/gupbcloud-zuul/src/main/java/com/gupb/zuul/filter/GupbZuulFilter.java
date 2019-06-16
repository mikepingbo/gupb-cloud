package com.gupb.zuul.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

@Component
public class GupbZuulFilter extends ZuulFilter {

    private final Logger logger = LoggerFactory.getLogger(GupbZuulFilter.class);

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        ctx.getResponse().setCharacterEncoding("UTF-8");
        ctx.getResponse().setContentType("application/json; charset=utf-8");

        // TODO 鉴权逻辑

        return ctx;
    }

    @Override
    public boolean shouldFilter() {
        // 此过滤器是否被启用，返回值true被启用，false不启用
        // 可以写业务逻辑判断是否被启用
        return true;
    }

    @Override
    public int filterOrder() {
        // 过滤器排序，0排在最前面
        return 0;
    }

    @Override
    public String filterType() {
        // 过滤器类型：pre:前置类型
        return "pre";
    }
}
