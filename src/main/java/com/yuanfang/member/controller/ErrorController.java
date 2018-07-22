package com.yuanfang.member.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {

    @RequestMapping("/errorIndex")
    public String errorIndex(){
        int i=3/0;
        return "success"+i;
    }

}
