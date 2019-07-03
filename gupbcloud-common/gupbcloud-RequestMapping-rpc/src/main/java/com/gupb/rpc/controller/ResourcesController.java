package com.gupb.rpc.controller;

import com.gupb.redis.service.RedisAUtils;
import com.gupb.rpc.bean.SystemResources;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


@RestController
@RequestMapping(value = "/mapping")
public class ResourcesController {

    @Autowired
    private WebApplicationContext applicationContext;

    @Autowired
    private RedisAUtils redisAUtils;

    @GetMapping("/parameter")
    public List<SystemResources> getAllUrl(){
        //请求url和处理方法的映射
        List<SystemResources> systemResourcesList = new ArrayList<SystemResources>();
        SystemResources systemResources = new SystemResources();

        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        //获取url与类和方法的对应信息
        Map<RequestMappingInfo,HandlerMethod> map = mapping.getHandlerMethods();
        for (RequestMappingInfo info : map.keySet()){
            //获取url的Set集合，一个方法可能对应多个url
            Set<String> patterns = info.getPatternsCondition().getPatterns();
            for (String url : patterns){
                systemResources = new SystemResources();
                systemResources.setUrl(url);
                systemResources.setContent(info.getName());
                systemResourcesList.add(systemResources);
            }
        }

        redisAUtils.set("order_test1", "yes");
        System.out.println(systemResourcesList);
        return systemResourcesList;
    }
}
