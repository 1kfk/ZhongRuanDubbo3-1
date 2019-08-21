package com.example;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.example.auth.JwtFilter;

import com.example.demo.ILoginUrl;

@ServletComponentScan
@SpringBootApplication
@EnableDubboConfiguration
public class SpringbootDubboClientApplication {
	/*
	@Bean
    public FilterRegistrationBean jwtFilter() {
		
		//regBean = new FilterRegistrationBean();
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        
        registrationBean.setFilter(new JwtFilter());
        //registrationBean.setInitParameters(Collections.singletonMap("services.auth", loginUrl.url()));
        //registrationBean.setInitParameters(Collections.singletonMap("services.auth", "http://localhost:9091/login" ));
        registrationBean.addUrlPatterns("/protected-resource");

        return registrationBean;
    }*/
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootDubboClientApplication.class, args);
	}
	

}
