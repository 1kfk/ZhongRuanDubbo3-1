package com.example.demo;

import java.util.List;

import com.example.bean.User;

public interface DBinterface {
	List<User> getAllUser(String find);
	User getUser(String username);
	int addUser(User user);
	int updateUser(User user);
	int delUser(int id,String username);
}
