package com.kaishengit.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kaishengit.Dao.UserDao;
import com.kaishengit.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserDaoTest {

	@Autowired
	private UserDao userDao;
	
	@Test
    public void save() {
        User user = new User();
        user.setName("Spring_JDBC");
        user.setAge(123123);

        userDao.save(user);
    }
	
	@Test
	public void delete(){
		userDao.delete(4);
	}
}
