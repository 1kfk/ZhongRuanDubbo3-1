package com.example.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.bean.User;
import com.example.demo.IHello;

public class Test {
	@Autowired
	private static UserMapper mservice;
	public static void main(String[] args) {
		System.out.println(mservice);
		User muser = mservice.getUser("www");
		System.out.println(muser);
	}
}
