package com.yuanfang.test01.service;

import com.github.pagehelper.PageInfo;
import com.yuanfang.model.User;

import java.util.List;


public interface UserServiceTest1 {

	User findByName( String name);

	int insert(String name, Integer age);

	PageInfo<User> fingUserList(int page, int pageSize);
}
