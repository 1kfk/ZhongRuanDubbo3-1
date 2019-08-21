package com.example.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.config.annotation.Service;
import com.example.auth.CookieUtil;
import com.example.auth.JwtUtil;


@Controller
public class LoginImpl {
	
	Logger logger = LoggerFactory.getLogger(LoginImpl.class);
	
	private static final String jwtTokenCookieName = "JWT-TOKEN";
    private static final String signingKey = "signingKey";
    private static final Map<String, String> credentials = new HashMap<>();
    
    public LoginImpl() {
    	credentials.put("abc", "123");
    }
    
    @RequestMapping("/")
    public String home(String redirect){
    	//logger.debug("--------home redirect----------"+redirect);
        return "redirect:/login?redirect="+redirect;//重定向到下一个目标， 需要指定redirect
    }

    @RequestMapping("/login")
    public String login(String redirect){
    	//logger.debug("--------login redirect----------"+redirect);
    	//model.addAttribute("redirect", redirect);
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(HttpServletResponse httpServletResponse, String username, String password, 
    		String redirect, Model model){
        if (username == null || !credentials.containsKey(username) || !credentials.get(username).equals(password)){
            model.addAttribute("error", "Invalid username or password!");
            return "login";
        }

        String token = JwtUtil.generateToken(signingKey, username);//生成jwt令牌
        CookieUtil.create(httpServletResponse, jwtTokenCookieName, token, false, -1, "127.0.0.1");//将jwt令牌存入cookie
        
        return "redirect:" + redirect;
    }

}
