package com.yuanfang.test02.service.impl;

import com.yuanfang.model.User;
import com.yuanfang.test02.mapper.UserMapperTest2;
import com.yuanfang.test02.service.UserServiceTest2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class UserServiceTest2Impl implements UserServiceTest2{

    @Autowired
    private UserMapperTest2 userMapperTest2;

    @Override
    public User findByName(String name) {
        return null;
    }

    @Override
    @Transactional
    public int insert(String name, Integer age) {
        int userResult=userMapperTest2.insert(name,age);
        int i=3/age;
        return userResult;
    }


}
