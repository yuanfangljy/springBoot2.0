package com.yuanfang.test02.service;

import com.yuanfang.model.User;



public interface UserServiceTest2 {

	User findByName(String name);

	int insert(String name, Integer age);

}
