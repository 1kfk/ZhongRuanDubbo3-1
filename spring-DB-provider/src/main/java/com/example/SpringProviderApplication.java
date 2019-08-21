package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.example.bean.User;
import com.example.demo.IHello;
import com.example.mapper.UserMapper;

@SpringBootApplication
@MapperScan(basePackages = "com.example.mapper")
@EnableDubboConfiguration
public class SpringProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProviderApplication.class, args);
	}

}
