package com.yuanfang.member.controller;

import com.yuanfang.service.AcynsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AcynsController {

    @Autowired
    private AcynsService acynsService;

    /**
     * 在项目启动时，初始化，进去读取配置文件（application）的信息
     */
    @Value("${name}")
    private String name;
    @Value("${httpUrl}")
    private String httpUrl;

    @RequestMapping("/IndexAcyns")

    public String IndexAcyns(){
        System.out.println("==============="+1);
        String result=acynsService.indexAcyns();
        System.out.println("==============="+2);
        return result;
    }

    /**
     * 查看配置环境
     * @return
     */
    @RequestMapping("/getName")
    public String getName(){
        return name+"---"+httpUrl;
    }



}
