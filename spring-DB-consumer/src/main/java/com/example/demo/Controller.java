package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.bean.User;
@org.springframework.stereotype.Controller
public class Controller {
	@Reference
	private DBinterface helloservice;
	
	@RequestMapping("get/{username}")
	@ResponseBody
	public User getUser(@PathVariable("username") String username) {
		return helloservice.getUser(username);
	}
	@RequestMapping(value="add")
	@ResponseBody
	public int addUser(User user) {
		return helloservice.addUser(user);
	}
	@RequestMapping(value="del/{id}/{username}")
	@ResponseBody
	public int deleteUser(@PathVariable("id") int id,@PathVariable("username") String username) {
		return helloservice.delUser(id,username);
	}
	@RequestMapping(value="up")
	@ResponseBody
	public int updateUser(User user) {
		return helloservice.updateUser(user);
	}
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
}
