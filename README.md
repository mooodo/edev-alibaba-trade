# 采用低代码平台编写的微服务系统 for nacos
这是一个Demo代码，演示了通过使用低代码平台来支持DDD领域驱动设计，使DDD更容易地落地微服务项目。

## 支持DDD的低代码平台
本项目通过使用低代码平台来支持DDD领域驱动设计，使DDD落地微服务项目更加容易，编写代码更少，
变更维护成本更低，使软件开发人员能够将更多的精力专注于学习业务领域知识、进行业务领域建模、设计出更加专业、用户
体验更好的软件系统。关于支持DDD的低代码平台，详情请见另一个相关的仓库：
```
edev-ddd-monolith   采用低代码平台编写的单体应用
* edev-ddd-support    支持DDD领域驱动设计的低代码平台
* edev-ddd-trade      采用低代码平台编写的业务操作系统
```

## 基于Spring Cloud Alibaba的微服务
本项目演示了基于Spring Cloud Alibaba的微服务设计：
```
edev-alibaba-parent             整个微服务项目的父项目
edev-alibaba-trade-customer     客户管理微服务
edev-alibaba-trade-product      产品管理微服务
edev-alibaba-trade-order        订单管理微服务
edev-alibaba-trade-inventory    库存管理微服务
edev-alibaba-trade-gateway      服务网关
```