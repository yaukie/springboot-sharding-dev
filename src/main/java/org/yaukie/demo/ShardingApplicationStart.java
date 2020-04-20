package org.yaukie.demo;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Author: yuenbin
 * @Date :2020/3/1
 * @Time :17:17
 * @Motto: It is better to be clear than to be clever !
 * @Destrib:
 **/
@MapperScan(basePackages = "org.yaukie.demo.*.dao.*")
@SpringBootApplication(scanBasePackages = "org.yaukie.*",exclude = {DataSourceAutoConfiguration.class, DruidDataSourceAutoConfigure.class})
@Slf4j
public class ShardingApplicationStart extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication();
         application.run(ShardingApplicationStart.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
         return application.sources(ShardingApplicationStart.class);
    }

}
