package com.yuanfang.test01.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuanfang.model.User;
import com.yuanfang.test01.mapper.UserMapperTest1;
import com.yuanfang.test01.service.UserServiceTest1;
import com.yuanfang.test02.mapper.UserMapperTest2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;

@Slf4j
@Service
public class UserServiceTest1Impl implements UserServiceTest1{

    @Autowired
    private UserMapperTest1 userMapperTest1;

    @Autowired
    private UserMapperTest2 userMapperTest2;//直接调用dao层中得方法则无法进行事物回归，要使用到分布式事物管理（AutoCAD）

    @Override
    public User findByName(String name) {
        return null;
    }

    //自定义注解式事物（要根据拦截器原理：对增删改）
    @Transactional
    public int insert(String name, Integer age){

       int userResult1= userMapperTest1.insert(name, age);
       int userResult2= userMapperTest2.insert(name, age);
       log.info("$$$$----&********"+userResult1+userResult2);
        //测试事物回滚，如果没有加@Transactional即使下面程序错了，数据库还是会添加信息
        int i=1/age;
        return userResult1+userResult2;

    }

    /**
     * 进行分页
     *  page 当前页数<br>
     * size 当前展示的数据<br>
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<User> fingUserList(int page, int pageSize) {
        // 开启分页插件,放在查询语句上面
        PageHelper.startPage(page,pageSize);
        List<User> userList= userMapperTest1.fingUserList();
        // 封装分页之后的数据
        PageInfo<User> pageInfoUser = new PageInfo<>(userList);

        //怎么样变成这样？    PageInfo<User> pageInfoUser= userMapperTest1.fingUserList();
        return pageInfoUser;
    }



    @Transactional
    public User selectByName(String name) {
        return userMapperTest1.findByName(name);
    }

    //例子：springboot中得异步
    @Async//异步：这段像多线程一样运行，不需要等待,,,要到app中加@EnableAsync//启动异步方法
    public String sendSms(){
        System.out.println("异步：============== 异步："+3);
        for (int i = 0; i < 3; i++) {
            System.out.println("循环："+i);
        }
        System.out.println("异步：============== 异步："+4);
        return "success";
    }
}
