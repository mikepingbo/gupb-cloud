# gupb-cloud  

## 前言  
`gupb-cloud`项目以互联网的技术思想为基础，打造成企业级微服务系统架构。  

## 项目介绍  
`gupb-cloud`项目定位为企业级微服务系统架构，包括基础服务、共通服务、后台管理服务、业务服务、组件化服务。  
架构基于SpringCloud实现。  
基础服务包括：服务注册与发现、配置中心、链路监控、实时应用监控平台、集群监控平台、网关服务、服务监控告警/时序数据监控平台、基础服务监控平台等。  
共通服务包括：MQ服务、ElasticSearch服务、NoSql服务、注解服务、分布式事务服务、多维度数据同步服务、定时任务服务、存储服务等。  
后台管理服务包括：Admin管理服务、Seller管理服务。  
业务服务包括：单点登录服务、鉴权服务、用户管理服务、等等。  
组件化服务包括：Feign API服务。  

### 组织结构

``` lua
gupbcloud-base
  ├── gupbcloud-erueka  服务注册与发现
  ├── gupbcloud-config  基于git管理配置中心，已被apollo取代
  ├── gupbcloud-zipkin  链路监控 基于elasticsearch存储
  ├── gupbcloud-CAT  实时应用监控平台
  ├── gupbcloud-hystrix-dashboard  集群监控平台
  ├── gupbcloud-zull 网关服务 基于netfix1.x (webmvc)
  ├── gupbcloud-gateway 网关服务 基于springcloud原生 (webflux)
  ├── gupbcloud-apollo 配置中心
  ├── gupbcloud-prometheus(Actuator+micrometer+metrics+Grafana) 服务监控告警/时序数据监控平台
gupbcloud-common
  ├── gupbcloud-annotation  注解服务管理
  ├── gupbcloud-core  服务实现
  ├── gupbcloud-mq  MQ服务管理
  ├── gupbcloud-redis  NoSql服务管理
  ├── gupbcloud-rpc  Bean服务管理
  ├── gupbcloud-util  工具服务管理
gupbcloud-backend
  ├── gupbcloud-admin  admin服务
  ├── gupbcloud-seller  seller服务
gupbcloud-customer
  ├── gupbcloud-sso  单点登录
  ├── gupbcloud-search  ES查询服务
  ├── gupbcloud-order  订单服务
  ├── gupbcloud-account  账户服务
  ├── gupbcloud-inventory  库存服务
gupbcloud-feign-api
  ├── gupbcloud-backend-admin-api  admin feign
  ├── gupbcloud-backend-seller-api  seller feign
  ├── gupbcloud-customer-sso-api  sso feign
  ├── gupbcloud-customer-search-api  search feign
  ......
```   

#### 架构图  

##### 系统架构图  
![系统架构图](gupbcloud-base/image/gupbcloud-image.png)

### 项目启动顺序
首先环境变量相关的内容配置好：JDK1.8、MySql数据库、Redis、RockerMQ、ElasticSearch(业务及监控)。  
启动Erueka、zipkin等监控服务 3、启动gateway或zull 4、启动各业务服务。  
