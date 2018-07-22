package com.yuanfang.member.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *springcloud依赖于springboot实现微服务，springboot默认集成springmvc组件，
 springcloud使用springmvc编写微服务http接口,通讯接口（http+json格式）
 */

@RestController
public class MemberController {
    /**
     * @RestController注解：表示该类中所有的方法返回json格式==@Controller+@ResponseBody
     * @RestController是springboot提供的吗？在springmvc4.0中就存在，为微服务提供返回json格式
     * SpringBoot启动原理：springmvc注解方式启动，内置http服务器（默认是tomcat）
     * @return
     */
    @RequestMapping("/indexMember")
    public String indexMember(){
        return "hello word!Springboot2.0";
    }
}
