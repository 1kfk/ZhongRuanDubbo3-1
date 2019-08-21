package com.example.auth;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.demo.ILoginUrl;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(urlPatterns= {"/protected-resource"})
public class JwtFilter extends OncePerRequestFilter {
    private static final String jwtTokenCookieName = "JWT-TOKEN";
    private static final String signingKey = "signingKey";

    @Reference(lazy=true, check=false)
    private ILoginUrl loginUrl;
    
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, 
    		FilterChain filterChain) throws ServletException, IOException {
        String username = JwtUtil.getSubject(httpServletRequest, jwtTokenCookieName, signingKey);
        if(username == null){
        	/*if(loginUrl==null) {
        		System.out.println("----------login url is null----------------------");
        	}else {
        		System.out.println("------in filter login url--------- " + loginUrl.url());
        	}*/
            //String authService = this.getFilterConfig().getInitParameter("services.auth");
        	//System.out.println("------in filter getRequestURL --------- " + httpServletRequest.getRequestURL());
        	String authService = loginUrl.url();
        	String tmp = authService + "?redirect=" + httpServletRequest.getRequestURL();
        	//System.out.println("------in filter tmp --------- " + tmp );
            httpServletResponse.sendRedirect( tmp );
        } else{
            httpServletRequest.setAttribute("username", username);
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
    }
}