package com.gupb.rpc.controller;

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
    WebApplicationContext applicationContext;

    @GetMapping("/parameter")
    public List<String> getAllUrl(){
        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        //获取url与类和方法的对应信息
        Map<RequestMappingInfo,HandlerMethod> map = mapping.getHandlerMethods();
        List<String> urlList = new ArrayList<String>();
        for (RequestMappingInfo info : map.keySet()){
            //获取url的Set集合，一个方法可能对应多个url
            Set<String> patterns = info.getPatternsCondition().getPatterns();
            System.out.println(info.getName());
            System.out.println(info.getConsumesCondition());
            for (String url : patterns){
                urlList.add(url);
            }
        }
        return urlList;
    }

    /**
     * 获取全部url及url名称
     * @param request
     * @return
     */
    @RequestMapping(value = "/allurl", method = RequestMethod.GET)
    public Object getAllUrl(HttpServletRequest request) {
        ServletContext servletContext = request.getSession().getServletContext();
        if (servletContext == null) {
            return null;
        }

        WebApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        //请求url和处理方法的映射
        List<SystemResources> systemResourcesList = new ArrayList<SystemResources>();
        SystemResources systemResources = new SystemResources();
        //获取所有的RequestMapping
        Map<String, HandlerMapping> allRequestMappings = BeanFactoryUtils.beansOfTypeIncludingAncestors(appContext,
                HandlerMapping.class, true, false);
        for (HandlerMapping handlerMapping : allRequestMappings.values()) {
            //本项目只需要RequestMappingHandlerMapping中的URL映射
            if (handlerMapping instanceof RequestMappingHandlerMapping) {
                RequestMappingHandlerMapping requestMappingHandlerMapping = (RequestMappingHandlerMapping) handlerMapping;
                Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();
                for (Map.Entry<RequestMappingInfo, HandlerMethod> requestMappingInfoHandlerMethodEntry : handlerMethods.entrySet()) {
                    systemResources = new SystemResources();
                    RequestMappingInfo requestMappingInfo = requestMappingInfoHandlerMethodEntry.getKey();
                    HandlerMethod mappingInfoValue = requestMappingInfoHandlerMethodEntry.getValue();
                    RequestMethodsRequestCondition methodCondition = requestMappingInfo.getMethodsCondition();

                    String url = requestMappingInfo.getPatternsCondition().toString().substring(1, requestMappingInfo.getPatternsCondition().toString().length() - 1);
                    String content = requestMappingInfo.getName() == null ? "请开发人员填写内容" : requestMappingInfo.getName().toString();

                    systemResources.setUrl(url);
                    systemResources.setContent(content);

                    systemResourcesList.add(systemResources);
                }
                break;
            }
        }
        System.out.println(systemResourcesList);
        return systemResourcesList;
    }
}
