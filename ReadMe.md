# Linzlb～ SpringBoot Demo
### Reference Documentation
For further reference, please consider the following sections:
* [Spring Boot 如何测试打包部署](http://www.ityouknow.com/springboot/2017/05/09/spring-boot-deploy.html)
* [Spring Boot 整合 Shiro-登录认证和权限管理](http://www.ityouknow.com/springboot/2017/06/26/spring-boot-shiro.html)
* [使用 Jenkins 部署 Spring Boot](http://www.ityouknow.com/springboot/2017/11/11/spring-boot-jenkins.html)
* [使用 Spring Boot 上传文件](http://www.ityouknow.com/springboot/2018/01/12/spring-boot-upload-file.html)
* [使用 Spring Boot 集成 FastDFS](http://www.ityouknow.com/springboot/2018/01/16/spring-boot-fastdfs.html)
* [使用 Spring Boot Actuator 监控应用](http://www.ityouknow.com/springboot/2018/02/06/spring-boot-actuator.html)
* [Spring Boot 如何解决项目启动时初始化资源](http://www.ityouknow.com/springboot/2018/05/03/spring-boot-commandLineRunner.html)
* [SpringBoot 常用部分](http://www.ityouknow.com/spring-boot.html)





###SpringBoot好处
Spring Boot 使用“习惯优于配置的理念”，采用包扫描和自动化配置的机制来加载依赖 Jar 中的 Spring bean，
不需要任何 Xml 配置，就可以实现 Spring 的所有配置。
所以只需要非常少的几个配置就可以迅速方便的搭建起来一套 Web 项目或者是构建一个微服务！
总结一下，使用 Spring Boot 至少可以给我们带来以下几方面的改进：
* Spring Boot 使编码变简单，Spring Boot 提供了丰富的解决方案，快速集成各种解决方案提升开发效率。
* Spring Boot 使部署变简单，Spring Boot 本身内嵌启动容器，仅仅需要一个命令即可启动项目，结合 Jenkins 、Docker 自动化运维非常容易实现。
* Spring Boot 使监控变简单，Spring Boot 自带监控组件，使用 Actuator 轻松监控服务各项状态。
* Spring Boot 使配置变简单，Spring Boot 提供了丰富的 Starters，集成主流开源产品往往只需要简单的配置即可。

###SOA和微服务的不同
微服务架构是 SOA 架构的传承，但一个最本质的区别就在于微服务是真正的分布式的、去中心化的。把所有的“思考”逻辑包括路由、消息解析等放在服务内部，去掉一个大一统的 ESB，服务间轻通信，是比 SOA 更彻底的拆分。微服务架构强调的重点是业务系统需要彻底的组件化和服务化，原有的单个业务系统会拆分为多个可以独立开发，设计，运行和运维的小应用，这些小应用之间通过服务完成交互和集成。

###项目结构
* pom文件为基本的依赖管理文件
* resouces 资源文件
    * statics 静态资源
    * templates 模板资源
    * application.yml or application.properties 配置文件
* SpringbootApplication程序的入口

###启动springboot 方式
```
cd到项目主目录:
mvn clean  
mvn package  编译项目的jar
mvn spring-boot: run 启动
cd 到target目录，java -jar 项目.jar
```
###整合elk，搭建实时日志平台
https://www.fangzhipeng.com/springboot/2017/05/22/sprinboot22-elk.html

###启动redis
```
cd /usr/local/redis-6.2.1/src/
./redis-server 
```