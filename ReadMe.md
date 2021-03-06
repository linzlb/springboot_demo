# Linzlb～ SpringBoot Demo
###项目结构
* pom                               文件为基本的依赖管理文件
* java                              类文件
    * aspect                        AOP切面相关的配置
    * config                        各种配置
    * configuration                 自定义的一些配置
    * consts                        常量定义
    * controller                    控制器
    * dao                           jpa的dao
    * dto                           dto
    * entity                        entity
    * interceptor                   自定义拦截器
    * mapper                        mybatis接口
    * service                       service
    * task                          定时任务
    * utils                         常用工具类
* resouces                          资源文件
    * templates                     模板资源
    * mapper                        mybatis的xml
    * application.properties/yml    配置文件
    * banner.txt                    启动的图案
* SpringbootApplication             程序的入口

### 项目对应的URL：
* [swagger-ui](http://127.0.0.1:8888/swagger-ui.html)
* [druid](http://127.0.0.1:8888/druid/login.html)

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
* [Redission使用](https://blog.csdn.net/liuxiao723846/article/details/88131065?utm_term=redission%E5%88%86%E5%B8%83%E5%BC%8F%E9%94%81&utm_medium=distribute.pc_aggpage_search_result.none-task-blog-2~all~sobaiduweb~default-2-88131065&spm=3001.4430)
* [Redission详解](https://blog.csdn.net/asd051377305/article/details/108384490?utm_medium=distribute.pc_relevant.none-task-blog-baidujs_utm_term-0&spm=1001.2101.3001.4242)
* [SpringBoot Actuator监控中心+AdminUI界面管理](https://blog.csdn.net/u011976388/article/details/85395130)
* [SpringBoot Druid整合+监控](https://www.cnblogs.com/DFX339/p/12751584.html)
* [整合elk，搭建实时日志平台](https://www.fangzhipeng.com/springboot/2017/05/22/sprinboot22-elk.html)
* [整合mybatis-plus](http://blog.java1234.com/index.html?typeId=43)
* [springboot参考资料](http://blog.battcn.com/categories/SpringBoot/)
* [轻松搞定安全框架（Shiro）](http://blog.battcn.com/2018/07/03/springboot/v2-other-shiro/)
* [通用Mapper与分页插件的集成](http://blog.battcn.com/2018/05/10/springboot/v2-orm-mybatis-plugin/)
* [优雅解决分布式限流](http://blog.battcn.com/2018/08/08/springboot/v2-cache-redislimter/)
* [过滤器，监听器，拦截器](https://www.cnblogs.com/qdhxhz/p/9043568.html)
* [logback日志](https://www.cnblogs.com/qdhxhz/p/9069980.html)
* [通过Lua脚本批量插入数据到Redis布隆过滤器](https://www.cnblogs.com/qdhxhz/p/11259078.html)
* [整合Druid实现多数据源和可视化监控](https://www.cnblogs.com/qdhxhz/p/10192041.html)
* [SpringBoot整合Apollo](https://www.cnblogs.com/qdhxhz/p/13449285.html)
* [kafka 安装 for mac](https://blog.csdn.net/oumuv/article/details/84860181)
* [SpringBoot集成kafka全面实战](https://blog.csdn.net/yuanlong122716/article/details/105160545/)
* [kafka教程1](https://www.cnblogs.com/qingyunzong/category/1212387.html)
* [kafka教程2](https://www.cnblogs.com/riches/category/1536304.html)
* [kafka教程3](https://baijiahao.baidu.com/s?id=1651919282506404758&wfr=spider&for=pc)
* [docker](https://www.runoob.com/docker/docker-container-usage.html)
* [docker](https://www.docker.org.cn/book/docker/what-is-docker-16.html)
* [springboot自动装配原理](https://www.cnblogs.com/javaguide/p/springboot-auto-config.html)
* [springboot常用注解](https://snailclimb.gitee.io/javaguide/#/./docs/system-design/framework/spring/SpringBoot+Spring%E5%B8%B8%E7%94%A8%E6%B3%A8%E8%A7%A3%E6%80%BB%E7%BB%93)
* [redis+lua实现分布式限流](http://blog.battcn.com/2018/08/08/springboot/v2-cache-redislimter/)
* [Maven中 jar包冲突原理与解决办法](https://blog.csdn.net/noaman_wgs/article/details/81137893)
* [微服务核心研究之--编排](https://www.jianshu.com/p/54e2e223dbac)
* [微服务架构的核心要点和实现原理](https://www.jianshu.com/p/97ced7ffe4f8)  
else:
* [MQTT](https://docs.emqx.cn/enterprise/v4.2/design/design.html)
* [docker](https://www.runoob.com/docker/docker-container-usage.html)
* [docker logs](https://cloud.tencent.com/developer/article/1486571)
* [jenkins](https://www.w3cschool.cn/jenkins/jenkins-6rwt28n7.html)
* [OSS](https://help.aliyun.com/document_detail/177682.html?spm=a2c4g.11186623.6.620.414113c0XjO9xB)
* [yuque note](https://www.yuque.com/sunxiaping/yg511q/pfa8a7)
* [canal](https://blog.csdn.net/yehongzhi1994/article/details/107880162)
* [springboot整合mqtt发送与订阅](https://blog.csdn.net/qq_31275085/article/details/105788873)
* [dubbo invoke](https://blog.csdn.net/weixin_28759537/article/details/113382975)
* [dubbo invoke](https://blog.csdn.net/u014082714/article/details/109094420?utm_medium=distribute.pc_aggpage_search_result.none-task-blog-2~aggregatepage~first_rank_v2~rank_aggregation-2-109094420.pc_agg_rank_aggregation&utm_term=dubbo%E7%9A%84invoke%E5%91%BD%E4%BB%A4&spm=1000.2123.3001.4430)
* [mybatis-plus](https://mp.baomidou.com/guide/crud-interface.html#alwaysupdatesomecolumnbyid)






###SpringBoot好处
```markdown
Spring Boot 使用“习惯优于配置的理念”，采用包扫描和自动化配置的机制来加载依赖 Jar 中的 Spring bean，
不需要任何 Xml 配置，就可以实现 Spring 的所有配置。
所以只需要非常少的几个配置就可以迅速方便的搭建起来一套 Web 项目或者是构建一个微服务！
总结一下，使用 Spring Boot 至少可以给我们带来以下几方面的改进：
* Spring Boot 使编码变简单，Spring Boot 提供了丰富的解决方案，快速集成各种解决方案提升开发效率。
* Spring Boot 使部署变简单，Spring Boot 本身内嵌启动容器，仅仅需要一个命令即可启动项目，结合 Jenkins 、Docker 自动化运维非常容易实现。
* Spring Boot 使监控变简单，Spring Boot 自带监控组件，使用 Actuator 轻松监控服务各项状态。
* Spring Boot 使配置变简单，Spring Boot 提供了丰富的 Starters，集成主流开源产品往往只需要简单的配置即可。
```

###SOA和微服务的不同
```markdown
微服务架构是 SOA 架构的传承，但一个最本质的区别就在于微服务是真正的分布式的、去中心化的。
把所有的“思考”逻辑包括路由、消息解析等放在服务内部，去掉一个大一统的 ESB，服务间轻通信，是比 SOA 更彻底的拆分。
微服务架构强调的重点是业务系统需要彻底的组件化和服务化，原有的单个业务系统会拆分为多个可以独立开发，设计，运行和运维的小应用，
这些小应用之间通过服务完成交互和集成。
```

###打包并启动springboot 方式
```
cd到项目主目录:
mvn clean  
mvn package  编译项目的jar
mvn spring-boot: run 启动
cd 到target目录，java -jar 项目.jar
```

###启动redis
```
cd /usr/local/redis-6.2.1/src/
./redis-server 
```

###启动zk&kakfa
```markdown
==> zookeeper
To have launchd start zookeeper now and restart at login:
    brew services start zookeeper
Or, if you don't want/need a background service you can just run:
    zkServer start
  
==> kafka
To have launchd start kafka now and restart at login:
    brew services start kafka
    
=======>
Or, if you don't want/need a background service you can just run:
    zookeeper-server-start -daemon /usr/local/etc/kafka/zookeeper.properties 
    & 
    kafka-server-start /usr/local/etc/kafka/server.properties
```
