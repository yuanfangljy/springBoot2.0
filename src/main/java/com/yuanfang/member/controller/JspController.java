package com.yuanfang.member.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

/**
 * jsp整个springBoot
 */
@Slf4j
@Controller
public class JspController {
    //传统方式打印日志
   // private static final org.slf4j.Logger logger = LoggerFactory.getLogger(JspController.class);

    @RequestMapping("/jspIndex")
    public String jspIndex(){
        log.info("SpringBoot 12312312  整合log4j");
        return "jspIndex";
    }
}
