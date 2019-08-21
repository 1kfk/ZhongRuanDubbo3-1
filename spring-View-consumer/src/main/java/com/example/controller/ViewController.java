package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.demo.ViewInterface;

@Controller
public class ViewController {
	@Reference
	private ViewInterface vServcie;
	@RequestMapping("/view")
	public String getIndex(Model model,@RequestParam(value = "find",defaultValue = "") String find){
		model.addAttribute("userList",vServcie.getAllUser(find));
		return "index";
	}
}
