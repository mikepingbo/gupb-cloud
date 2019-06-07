package com.gupb.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class swaggerBean {

    @Component
    @Primary
    class DocumentationConfig implements SwaggerResourcesProvider {
        @Bean
        public ServletRegistrationBean getServlet() {
            HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
            ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
            registrationBean.setLoadOnStartup(1);
            registrationBean.addUrlMappings("/hystrix.stream");
            registrationBean.setName("HystrixMetricsStreamServlet");
            return registrationBean;
        }

        @Override
        public List<SwaggerResource> get() {
            List resources = new ArrayList();
            resources.add(swaggerResource("Order系统","/gupb/order/v2/api-docs","2.0"));
            resources.add(swaggerResource("Account系统","/gupb/account/v2/api-docs","2.0"));
            resources.add(swaggerResource("Inventory系统","/gupb/inventory/v2/api-docs","2.0"));
            resources.add(swaggerResource("SSO单点登录系统","/gupb/sso/v2/api-docs","2.0"));
            resources.add(swaggerResource("Admin管理系统","/gupb/admin/v2/api-docs","2.0"));
            resources.add(swaggerResource("Seller管理系统","/gupb/seller/v2/api-docs","2.0"));


            return resources;
        }

        private SwaggerResource swaggerResource(String name, String location, String version) {
            SwaggerResource swaggerResource = new SwaggerResource();
            swaggerResource.setName(name);
            swaggerResource.setLocation(location);
            swaggerResource.setSwaggerVersion(version);
            return swaggerResource;
        }
    }
}
