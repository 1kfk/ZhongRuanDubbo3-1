package com.example;

import org.springframework.context.annotation.PropertySource;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.example.demo.HelloService;

@org.springframework.context.annotation.Configuration
@EnableDubbo(scanBasePackageClasses = HelloService.class)
@PropertySource("dubbo-provider.properties")
public class Configuration {

}
