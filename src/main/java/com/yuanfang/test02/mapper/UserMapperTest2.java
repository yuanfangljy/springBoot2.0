package com.yuanfang.test02.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yuanfang.model.User;

public interface UserMapperTest2 {

	@Select("Select * from user where name= #{name}")
	User findByName(@Param("name") String name);
	
	@Insert("insert into User(name, age) values(#{name}, #{age})")
	int insert(@Param("name") String name, @Param("age") Integer age);
}
