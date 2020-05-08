#基础镜像
FROM openjdk:12
#作者信息
MAINTAINER yuenbin <yaukie@163.com>
#挂在目录
VOLUME /tmp 
#复制jar包到指定目录
ADD *.jar app.jar 
#设置环境变量
ENV JAVA_HOME /usr/java/jdk1.8.0_121 
ENV PATH $JAVA_HOME/bin:$PATH 
ENTRYPOINT ['java','-Dspring.profiles.active=prod','-jar','app.jar']
#暴露端口
EXPOSE 8099
