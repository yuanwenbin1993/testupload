package com.tarena.mapperproxy;

import org.junit.Test;

import com.tarena.dao.UserMapper;
import com.tarena.entity.User;

public class TestClass {
	@Test
	public void testMapperSelf(){
		UserMapper userMapper=(UserMapper)MapperProxy.getMapper(UserMapper.class);
		User user=userMapper.findUserById(25);
		System.out.println(user);
	}
}
