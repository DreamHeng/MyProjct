package com.kaishengit.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kaishengit.entity.User;
import com.kaishengit.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class MyBatisTest {
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void save(){
		
		User user = new User();
		user.setName("ะกำใ");
		user.setAge(3);
		
		userMapper.save(user);
	}
	
}
