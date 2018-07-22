package com.yuanfang.member.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 热部署工具：devtools
 * 1、采用自动重启服务器，要重新映射的url地址
 * 2、按保存就进行重启
 * 3、项目大，不介意使用
 */
@RestController
public class DevTools {

    @RequestMapping("/devIndex")
    public String devIndex(){
        String liu="liujiayi---+++-----+++--";
        return "devTools2.0+9090"+liu;
    }
}
