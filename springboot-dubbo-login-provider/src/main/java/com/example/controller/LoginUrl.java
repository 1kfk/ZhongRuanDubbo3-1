package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.demo.ILoginUrl;


@Service
@Component
public class LoginUrl implements ILoginUrl {
	@Override
	public String url() {
		// TODO Auto-generated method stub
		return "http://127.0.0.1:9091/";
	}
}
