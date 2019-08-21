package com.example.demo;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.bean.User;

@Service
public interface IHello {
	String hello();
}
