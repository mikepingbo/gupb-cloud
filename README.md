### 项目启动顺序
1、首先环境变量相关的内容配置好：JDK1.8、MySql数据库、Redis、RockerMQ、ElasticSearch(业务及监控)

2、启动Erueka、zipkin等监控服务
3、启动gateway或zull
4、启动各业务服务

### Project Name：gupb-cloud（Ongoing）
> gupbcloud-base(架构基础服务)
> >  	gupbcloud-erueka  架构完成
> >  	gupbcloud-config  架构完成（apollo已取代）
> >  	gupbcloud-zipkin  架构完成（基于elasticsearch存储）
> >  	gupbcloud-CAT  实时应用监控平台(美团点评开发，需要埋点，一种解决方案)
> >  	gupbcloud-hystrix-dashboard  架构完成
> >  	gupbcloud-admin 未开始
> >  	gupbcloud-zull 架构完成 基于netfix1.x (webmvc)
> >  	gupbcloud-gateway 架构完成 基于springcloud原生 (webflux)
> >  	gupbcloud-apollo 架构已添加  架构修改过，适应此工程
> >  	gupbcloud-prometheus(Actuator+micrometer+metrics+Grafana) 未开始微  服务监控告警/时序数据监控
> gupbcloud-customer（业务服务）
> > 	gupbcloud-sso 未开始
> > 	gupbcloud-member 未开始
> > 	gupbcloud-search 未开始
> > 	gupbcloud-seller 未开始
> > 	gupbcloud-pay 未开始
> > 	gupbcloud-order 开发中
> > 	gupbcloud-product 未开始
> > 	gupbcloud-promotion 未开始
> > 	gupbcloud-seckill 未开始
> > 	gupbcloud-loganalysis 未开始
> > 	gupbcloud-third 未开始
> > 	gupbcloud-util 未开始
> gupbcloud-backend（后端管理服务）
> > 	gupbcloud-admin  架构完成
> > 	gupbcloud-seller  架构完成
> > 	gupbcloud-schedule 未开始
> gupbcloud-core
> > 	gupbcloud-mq-service 架构基本成型
> > 	gupbcloud-es-service 未开始
> > 	gupbcloud-redis-service 未开始
> > 	gupbcloud-feign-service 架构基本成型
> > 	gupbcloud-utis-service 未开始
> gupbcloud-common（架构共通服务jar）
> > 	gupbcloud-mq 架构完成
> > 	gupbcloud-es （放到search服务中了）
> > 	gupbcloud-redis 已完成，多NOSQL支持
> > 	gupbcloud-feign 架构完成
> > 	gupbcloud-util 架构基本成型
> gupbcloud-feign-api（服务间调用）
> > 	gupbcloud-backend-admin-api  架构基本成型
> > 	gupbcloud-backend-seller-api  架构基本成型
> > 	gupbcloud-backend-sso-api  架构基本成型
> > 	gupbcloud-backend-member-api 未开始
> > 	gupbcloud-backend-search-api 未开始
> > 	gupbcloud-backend-seller-api 架构基本成型
> > 	gupbcloud-backend-pay-api 架构基本成型
> > 	gupbcloud-backend-order-api 架构基本成型
> > 	gupbcloud-backend-product-api 未开始
> gupbcloud-bigdata（准实时、离线数据分析）
> > 	gupbcloud-logstash 未开始
> > 	gupbcloud-kafka 未开始
> > 	gupbcloud-hadoop 未开始
> gupbcloud-sh（linux服务器支撑基础服务）
> > 	gupbcloud-sql sql自动生成工具等
> > 	gupbcloud-elk 日志离线分析架构
> > 	gupbcloud-nginx 反向代理工具
> > 	gupbcloud-zk
> > 	gupbcloud-devops 持续化开发工具
> > 	gupbcloud-gitlib git管理工具
> > 	gupbcloud-jenkins redis java api调用
> > 	gupbcloud-zentao 禅道
> > 	gupbcloud-swagger 架构已完成
> > 	gupbcloud-maven  maven本地仓库建设
> > 	gupbcloud-idea 开发工具
> > 	gupbcloud-xsell-secureCRT sell执行工具
> > 	gupbcloud-sqlyong sql执行工具
> > 	gupbcloud-mybatis spring持久层

此架构的设计初衷，能承载至少是中级规模电商的QPS TPS
架构介绍暂时没有时间完成，以后会慢慢添加
