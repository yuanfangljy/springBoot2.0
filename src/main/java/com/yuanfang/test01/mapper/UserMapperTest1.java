package com.yuanfang.test01.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yuanfang.model.User;

import java.util.List;

public interface UserMapperTest1 {

	@Select("Select * from user")
	List<User> fingUserList();

	@Select("Select * from user where name= #{name}")
	User findByName(@Param("name") String name);
	
	@Insert("insert into User(name, age) values(#{name}, #{age})")
	int insert(@Param("name") String name, @Param("age") Integer age);


}
