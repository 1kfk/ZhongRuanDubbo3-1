package com.example.resource;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.auth.CookieUtil;
import com.example.demo.ILoginUrl;

@Controller
public class ResourceController {
	private static final String jwtTokenCookieName = "JWT-TOKEN";

	//@Reference
	//private ILoginUrl loginUrl;
	
    @RequestMapping("/")
    public String home() {
    	
    	//System.out.println( "------------------------ "+loginUrl.url() );
        return "redirect:/protected-resource";
    }

    @RequestMapping("/protected-resource")
    public String protectedResource() {
        return "redirect:http://127.0.0.1:8335/view";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletResponse httpServletResponse) {
        CookieUtil.clear(httpServletResponse, jwtTokenCookieName);
        return "redirect:/";
    }
}
