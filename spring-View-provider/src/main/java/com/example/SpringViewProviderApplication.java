package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

@SpringBootApplication
@EnableDubboConfiguration
public class SpringViewProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringViewProviderApplication.class, args);
	}

}
