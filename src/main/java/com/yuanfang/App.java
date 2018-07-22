package com.yuanfang;

import com.yuanfang.config.DBConfig1;
import com.yuanfang.config.DBConfig2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 项目启动：整个程序的入口
 * @EnableAutoConfiguration：注解作用：扫包范围默认在当前类里面
 * @EnableAsync :异步请求
 * @MapperScan ：mapper扫包
 * 1、启动方式：@EnableAutoConfiguration @ComponentScan("com.yuanfang.member.controller")
 * 2、启动方式：@SpringBootApplication==@EnableAutoConfiguration+@ComponentSca（扫同级包和当前包）
 */
@EnableAsync
@SpringBootApplication()
//@EnableAutoConfiguration
//@ComponentScan(basePackages = {"com.yuanfang.member.controller","com.yuanfang.test01","com.yuanfang.test02","com.yuanfang.service"})
//再配置分布式事物时，要进行注入
@EnableConfigurationProperties(value={DBConfig1.class,DBConfig2.class})
//@MapperScan(basePackages = {"com.yuanfang.test01.mapper","com.yuanfang.test02.mapper"})
public class App {

    public static void main(String[] args) {

        SpringApplication.run(App.class,args);
    }
}
