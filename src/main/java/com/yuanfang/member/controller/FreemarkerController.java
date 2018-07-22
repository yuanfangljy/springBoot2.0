package com.yuanfang.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class FreemarkerController {

    @RequestMapping("/ftlIndex")
    public String ftlIndex(Map<String,Object> map){
        map.put("name","曾雨琪是个可爱的宝宝！");//其实就是request.set..页面响应
        map.put("age","17");
        map.put("sex","1");
        return "ftlIndex";
    }

}
