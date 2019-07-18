package com.gupb.rpc.controller;

import com.gupb.redis.service.RedisAUtils;
import com.gupb.rpc.bean.SystemResources;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import java.util.*;


@RestController
@RequestMapping(value = "/mapping")
public class ResourcesController {

    @Autowired
    private WebApplicationContext applicationContext;

    @Autowired
    private RedisAUtils redisAUtils;

    @Value("${spring.application.name:all}")
    private String applicationName;

    @GetMapping("/parameter")
    public List<SystemResources> getAllUrl(){
        //请求url和处理方法的映射
        List<SystemResources> systemResourcesList = new ArrayList<SystemResources>();
        SystemResources systemResources = new SystemResources();
        Set<String> urls = new HashSet();

        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        //获取url与类和方法的对应信息
        Map<RequestMappingInfo,HandlerMethod> map = mapping.getHandlerMethods();
        for (RequestMappingInfo info : map.keySet()){
            //获取url的Set集合，一个方法可能对应多个url
            Set<String> patterns = info.getPatternsCondition().getPatterns();
            for (String url : patterns){
                if (!checkName(info.getName())) {
                    continue;
                }
                systemResources = new SystemResources();
                systemResources.setUrl(url);
                systemResources.setContent(info.getName());
                systemResourcesList.add(systemResources);
                urls.add(url);
            }
        }

        redisAUtils.setObjectNoEx(applicationName + "_frontend_urls", urls);
        System.out.println(systemResourcesList);
        return systemResourcesList;
    }

    private boolean checkName(String name) {
        if (StringUtils.isEmpty(name)) {
            return false;
        }
        String nameToLowerCase = name.toLowerCase();
        if (nameToLowerCase.indexOf("frontend") != -1) {
            return true;
        }
        return false;
    }
}
