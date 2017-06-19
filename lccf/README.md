# Spring Boot 你值得拥有

 最近在看spring boot 觉得还是蛮强大的,所以和朋友一起搭建一套基于spring boot的框架，把一些知识点都整合进去

  项目架构：

          前后端分离的方式 ，前台采用ag2

          功能内聚分包（dao、service、cache、util、web），后期会采用微服务的架构 在功能内聚的基础上进行业务分包
   功能点：

          restful api风格，整合[swagger-ui](http://swagger.io/swagger-ui/)（前后端分离契约 方便接口调试）

          权限采用 jwt+ang2（使用路由过滤）

          后台验证（aop注解+validate） 进行统一处理

          自定义异常+spring统一异常处理

          spring-jpa 数据操作
   
  包功能介绍：

          lccf-web：controller 提供API服务

          lcc-service：service 业务逻辑层

          lccf-repository：数据交互层

          lccf-test：提供测试，依赖了lccf-web，可以测试 web、service、repository层的代码 发布的时候不会发布进去

## **联系方式**

* email: liccwork@126.com

* github: https:\/\/github.com\/licc168\/

