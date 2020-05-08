# 项目简介  

本项目是基于springboot实现,架构风格完全符合当前主流的微服务思想.本项目整合了  
mybatis,通过代码机实现前后端分离,通过内置jetty服务器即可发布基础微服务.主要有如下特点:  
1. 本实例实现了代码机流程,通过代码机实现VO层(DTO层),CONTROLLER层,SERVICE层,DAO层的完整实现  
2. 集成shardingJDBC,基本实现数据库的分库分表,数据切片,数据脱敏,以及分布式事务等  
3. 项目集成热部署实例,很方便调试,重启
4. 项目集成swagger文档操作,方便管理接口文档
5. 增加彩色日志打印,使得开发效果更佳,提升编码欲望
彩色日志一览:  

 ![Image text](http://open.inspur.com/yuenbin/springboot-sharding-pro/raw/master/folder/03.png)  
 ![Image text](https://raw.githubusercontent.com/yaukie/springboot-sharding-pro/master/folder/03.png)   
  ----   
  
# ShardingSphere   

## Sharding-JDBC   
定位为轻量级Java框架，在Java的JDBC层提供的额外服务。 它使用客户端直连数据库，以jar包形式    
提供服务，无需额外部署和依赖，可理解为增强版的JDBC驱动，完全兼容JDBC和各种ORM框架。  

适用于任何基于JDBC的ORM框架，如：JPA, Hibernate, Mybatis, Spring JDBC Template或直接使用JDBC。  
支持任何第三方的数据库连接池，如：DBCP, C3P0, BoneCP, Druid, HikariCP等。  
支持任意实现JDBC规范的数据库。目前支持MySQL，Oracle，SQLServer，PostgreSQL以及任何遵循SQL92标准的数据库。  

架构图如下:  

 ![Image text](http://open.inspur.com/yuenbin/springboot-sharding-pro/raw/master/folder/01.png)  
 ![Image text](https://raw.githubusercontent.com/yaukie/springboot-sharding-pro/master/folder/01.png)   
 
 ----  
 
 ## Sharding-Proxy   
 
 定位为透明化的数据库代理端，提供封装了数据库二进制协议的服务端版本，用于完成对异构语言的支持。    
  目前先提供MySQL/PostgreSQL版本，它可以使用任何兼容MySQL/PostgreSQL协议的访问客户端(如：    
  MySQL Command Client, MySQL Workbench, Navicat等)操作数据，对DBA更加友好。  
 
 向应用程序完全透明，可直接当做MySQL/PostgreSQL使用。  
 适用于任何兼容MySQL/PostgreSQL协议的的客户端。  
 架构图如下:  
  ![Image text](http://open.inspur.com/yuenbin/springboot-sharding-pro/raw/master/folder/02.png)  
  ![Image text](https://raw.githubusercontent.com/yaukie/springboot-sharding-pro/master/folder/02.png)   
 
 ----  
 
# 项目结构  

项目由三部分组成:

### 1. springboot-sharding-pro   
    这个是父级项目,也就是顶级项目,管理子项目所需要的所有jar包,以及对应版本,供子项目使用.  
    该项目组件仅充当管理角色,jar包管理都在pom.xml文件中
 
### 2. springboot-sharding-base  
     这个是微服务基础组件,集成了自动代码机案例,为springboot-sharding-dev提供统一的接口入口, 如下是结构图:  
       
     ├─src
     │  ├─main
     │  │  ├─java
     │  │  │  └─org
     │  │  │      └─yaukie
     │  │  │          └─api
     │  │  │              ├─base
     │  │  │              │  ├─bean
     │  │  │              │  │      ApplicationContextListener.java
     │  │  │              │  │      SpringContextUtil.java
     │  │  │              │  │      
     │  │  │              │  └─core
     │  │  │              │          BaseService.java
     │  │  │              │          Service.java
     │  │  │              │          
     │  │  │              ├─constant
     │  │  │              │      BaseResult.java
     │  │  │              │      BaseResultConstant.java
     │  │  │              │      PageResult.java
     │  │  │              │      
     │  │  │              ├─dto
     │  │  │              │      BaseData.java
     │  │  │              │      
     │  │  │              └─util
     │  │  │                      DatabaseUtil.java
     │  │  │                      GeneratorUtil.java
     │  │  │                      
     │  │  └─resources
     │  │      │  log4j.properties
     │  │      │  
     │  │      └─template
     │  │              template-controller.ftl
     │  │              template-EntityVO.ftl
     │  │              template-RequestVO.ftl
     │  │              template-ResponseVO.ftl
     │  │              template-service.ftl
     │  │              template-serviceimpl.ftl
     │  │              
     │  └─test
     │      └─java
         │  └─template
         │          template-controller.ftl(业务层模板)
         │          template-EntityVO.ftl(实体层模板)
         │          template-RequestVO.ftl(请求层模板)
         │          template-ResponseVO.ftl(响应层模板)
         │          template-service.ftl(服务层模板)
         │          template-serviceimpl.ftl(服务实现层模板)  
         
       功能描述:  
       1. 代码机具体实现逻辑,都在base层  
       2. 提供规范化的请求响应机制  
       3. 提供代码机实现模板  
       4. 提供数据接口层基本的规范操作  
       5. 可以根据需要,自定义设置框架模板
     
### 3.springboot-sharding-dev  
        这个组件是具体干活的实现,集成了shardingjdbc以及Druid实现数据库连接,热部署等,项目结构如下:  
       
        ├─doc
        │  └─database
        │      ├─MySql_ds0
        │      │      create.sql
        │      │      init.sql
        │      │      
        │      └─MySql_ds1
        │              create.sql
        │              init.sql
        │              
        ├─jenkins
        │      dev.groovy
         ─src
        │  ├─main
        │  │  ├─java
        │  │  │  └─org
        │  │  │      └─yaukie
        │  │  │          └─demo
        │  │  │              │  ShardingApplicationStart.java
        │  │  │              │  Swagger2.java
        │  │  │              │  
        │  │  │              ├─autocode
        │  │  │              │  │  Generator.java
        │  │  │              │  │  
        │  │  │              │  ├─controller
        │  │  │              │  │      TEncryptOrderController.java
        │  │  │              │  │      TOrderController.java
        │  │  │              │  │      TOrderItemController.java
        │  │  │              │  │      TUserController.java
        │  │  │              │  │      
        │  │  │              │  ├─dao
        │  │  │              │  │  └─mapper
        │  │  │              │  │          TEncryptOrderMapper.java
        │  │  │              │  │          TOrderItemMapper.java
        │  │  │              │  │          TOrderMapper.java
        │  │  │              │  │          TUserMapper.java
        │  │  │              │  │          
        │  │  │              │  ├─model
        │  │  │              │  │      TEncryptOrder.java
        │  │  │              │  │      TEncryptOrderExample.java
        │  │  │              │  │      TOrder.java
        │  │  │              │  │      TOrderExample.java
        │  │  │              │  │      TOrderItem.java
        │  │  │              │  │      TOrderItemExample.java
        │  │  │              │  │      TUser.java
        │  │  │              │  │      TUserExample.java
        │  │  │              │  │      
        │  │  │              │  ├─service
        │  │  │              │  │  ├─api
        │  │  │              │  │  │      TEncryptOrderService.java
        │  │  │              │  │  │      TOrderItemService.java
        │  │  │              │  │  │      TOrderService.java
        │  │  │              │  │  │      TUserService.java
        │  │  │              │  │  │      
        │  │  │              │  │  └─impl
        │  │  │              │  │          TEncryptOrderServiceImpl.java
        │  │  │              │  │          TOrderItemServiceImpl.java
        │  │  │              │  │          TOrderServiceImpl.java
        │  │  │              │  │          TUserServiceImpl.java
        │  │  │              │  │          
        │  │  │              │  └─vo
        │  │  │              │      ├─entity
        │  │  │              │      │      TEncryptOrderEntityVO.java
        │  │  │              │      │      TOrderEntityVO.java
        │  │  │              │      │      TOrderItemEntityVO.java
        │  │  │              │      │      TUserEntityVO.java
        │  │  │              │      │      
        │  │  │              │      ├─request
        │  │  │              │      │      TEncryptOrderRequestVO.java
        │  │  │              │      │      TOrderItemRequestVO.java
        │  │  │              │      │      TOrderRequestVO.java
        │  │  │              │      │      TUserRequestVO.java
        │  │  │              │      │      
        │  │  │              │      └─response
        │  │  │              │              TEncryptOrderResponseVO.java
        │  │  │              │              TOrderItemResponseVO.java
        │  │  │              │              TOrderResponseVO.java
        │  │  │              │              TUserResponseVO.java
        │  │  │              │              
        │  │  │              ├─filter
        │  │  │              │      DruidStatWebFilter.java
        │  │  │              │      
        │  │  │              ├─servlet
        │  │  │              │      DruidStatWebServlet.java
        │  │  │              │      
        │  │  │              └─sharding
        │  │  │                      AutoHintShardingAlgorithm.java
        │  │  │                      
        │  │  └─resources
        │  │      │  application-encrypt.yml
        │  │      │  application-hint.yml
        │  │      │  application-sharding.properties_01
        │  │      │  application-sharding.yml
        │  │      │  application.properties_01
        │  │      │  application.yml
        │  │      │  log4j.dtd
        │  │      │  logback-spring.xml
        │  │      │  
        │  │      └─mapper
        │  │              TEncryptOrderMapper.xml
        │  │              TOrderItemMapper.xml
        │  │              TOrderMapper.xml
        │  │              TUserMapper.xml
        │  │              
        │  └─test
        │      └─java
        │          └─org
        │              └─yaukie
        │                  └─test
        │                          ShardingJdbcTest.java   
        
        功能描述:
        1. 实现shardingjdbc的集成  
        2. 实现分库分表功能  
        3. 实现数据分片功能  
        4. 实现数据脱敏功能  
        5. 实现分布式事务功能  
        6. 实现热部署功能    

----  

# 项目亮点  

### 1. 自动代码机  
详见上述springboot-sharding-base介绍

### 2.  RunDashboard控制台  
        实现方式很简单,找到根目录下的.idea/workspace.xml文件,找到如下图所示的内容  :
        加入configurationTypes配置即可:
          <component name="RunDashboard">
             <option name="configurationTypes">
              <set>
                <option value="SpringBootApplicationConfigurationType" />
              </set>
            </option>
            </component>  
            配置完成,重启idea,得到如下图所示,表示成功:  
   ![Image text](http://open.inspur.com/yuenbin/springboot-sharding-pro/raw/master/folder/06.png)  
   ![Image text](https://raw.githubusercontent.com/yaukie/springboot-sharding-pro/master/folder/06.png)   
             

### 3. 热部署,自动重启  



### 4.  彩色日志打印  
        
        
        
----  


## 使用方法
  ### 1.  检下项目  
     执行 git clone 命令,将如下三个项目检下来:  
     1. [https://github.com/yaukie/springboot-sharding-base.git](https://github.com/yaukie/springboot-sharding-base.git)   
     2. [https://github.com/yaukie/springboot-sharding-dev.git](https://github.com/yaukie/springboot-sharding-dev.git)   
     3. [https://github.com/yaukie/springboot-sharding-pro.git](https://github.com/yaukie/springboot-sharding-pro.git)  
 ### 2. 配置maven  
     本实例使用的是阿里云的私有仓库,并将本地jar信息推送到此,以做统一管理,因此,如果要使用本项目,您需要根据情况,配置一下setting.xml  
     文件,使用idea引入项目之后,执行mvn clean install -U 强制更新,将依赖jar导入到本地仓库.  
     本例的项目jar已经推送到阿里云的私有仓库,见如下图,读者使用的时候,可以直接按照上述配置更新到本地:  
   ![Image text](http://open.inspur.com/yuenbin/springboot-sharding-pro/raw/master/folder/07.png)  
   ![Image text](https://raw.githubusercontent.com/yaukie/springboot-sharding-pro/master/folder/07.png)  
       
 ### 3. 配置数据库  
     1. 设置本地mysql数据库,执行springboot-sharding-dev/doc/目录下的mysql建库,建表语句,在本地建响应的数据表.   
     2. 修改springboot-sharding-dev项目下对应的yml文件, yml说明如下:  
            a. application.yml是项目启动主入口  
            b. application-encrypt.yml是数据脱敏演示  
            c. application-hint.yml是自定义强制路由演示   
            d.application-sharding.yml是数据分片,数据库分离演示  
     请跟进情况自行配置,并演示效果.  
 ### 4. 启动  
        设置完步骤3之后,直接进入到springboot-sharding-dev的主启动类(ShardingApplicationStart)启动项目  
        启动之后,访问http://localhost:8009/sharding/swagger-ui.html  出现如下访问页面,则表示环境运行成功:  
 ![Image text](http://open.inspur.com/yuenbin/springboot-sharding-pro/raw/master/folder/04.png)  
 ![Image text](https://raw.githubusercontent.com/yaukie/springboot-sharding-pro/master/folder/04.png)   
 ### 要想启动好项目,请配置好相关的jar包依赖,这里不再赘述  
    
--- 

## 仓库管理  

  ![Image text](http://open.inspur.com/yuenbin/springboot-sharding-pro/raw/master/folder/05.png)  
  ![Image text](https://raw.githubusercontent.com/yaukie/springboot-sharding-pro/master/folder/05.png)   

 ----  
 
 
 # 子项目链接  
 
 1. [https://github.com/yaukie/springboot-sharding-base.git](https://github.com/yaukie/springboot-sharding-base.git)   
 2. [https://github.com/yaukie/springboot-sharding-dev.git](https://github.com/yaukie/springboot-sharding-dev.git)   
 
 ----   
 
 
# 后续规划  
     1. 使用docker+jenkins完成持续集成部署  
     2. 创建阿里云镜像仓库,通过仓库进行管理  
     
     
