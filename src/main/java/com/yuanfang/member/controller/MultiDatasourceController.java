package com.yuanfang.member.controller;

import com.github.pagehelper.PageInfo;
import com.yuanfang.model.User;
import com.yuanfang.test01.service.impl.UserServiceTest1Impl;
import com.yuanfang.test02.service.impl.UserServiceTest2Impl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 多数据源：插入不同的数据库中
 */
@RestController
public class MultiDatasourceController {

    @Autowired
    private UserServiceTest1Impl userServiceTest01;

    @Autowired
    private UserServiceTest2Impl userServiceTest02;

    @RequestMapping("/userMapperTest1")
    public String userMapperTest1(String name,Integer age){
        System.out.println("-------------");
        userServiceTest01.insert(name, age);
        System.out.println("-------------++++++++++++++++");
        return "success";
    }

    @Test
    public void userMapperTest(){
        System.out.println("-------------");
        userServiceTest01.insert("123", 12);
        System.out.println("-------------++++++++++++++++");

    }


    @RequestMapping("/findByName")
    public User findByName(String name){
        System.out.println("-------------");

        return userServiceTest01.findByName(name);
    }

    @RequestMapping("/userMapperTest2")
    public String userMapperTest2(String name,Integer age){
        userServiceTest02.insert(name, age);
        return "success";
    }


    @RequestMapping("/pageUser")
    public PageInfo<User> pageUser(int page, int pageSize){
        return  userServiceTest01.fingUserList(page,pageSize);
    }


}
