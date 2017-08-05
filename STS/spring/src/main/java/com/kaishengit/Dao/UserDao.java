package com.kaishengit.Dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kaishengit.entity.User;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void delete(Integer id){
		String sql = "delete * from t_user where id = ?";
		jdbcTemplate.update(sql,id);
	}
	
	public void save(User user) {
		String sql = "insert into t_user(user_name,password,address,dept_id) values(?,?,?,?)";
		jdbcTemplate.update(sql,user.getName(),user.getAge());
	}

}
