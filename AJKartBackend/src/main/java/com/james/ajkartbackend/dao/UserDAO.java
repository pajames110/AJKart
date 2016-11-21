package com.james.ajkartbackend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.james.ajkartbackend.model.User;

@Repository
public interface UserDAO {
	public boolean save(User user);
	public boolean update(User user);
	public boolean delete(User user);
	public User get(String i);
	
	public List<User> list();

}
