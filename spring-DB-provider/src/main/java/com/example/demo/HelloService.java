package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.bean.User;
import com.example.mapper.UserMapper;

@Component
@Service
public class HelloService implements DBinterface{
	@Autowired
	private UserMapper userMapper;
	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateUser(user);
	}

	@Override
	public int delUser(int id, String username) {
		// TODO Auto-generated method stub
		return userMapper.deleteUser(id, username);
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return userMapper.getUser(username);
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.insertUser(user);
	}

	@Override
	public List<User> getAllUser(String find) {
		// TODO Auto-generated method stub
		return userMapper.getAllUser(find);
	}
	
}
