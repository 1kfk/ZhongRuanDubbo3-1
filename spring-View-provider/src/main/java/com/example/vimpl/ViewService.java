package com.example.vimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.example.bean.User;
import com.example.demo.DBinterface;
import com.example.demo.ViewInterface;
@Component
@Service
public class ViewService implements ViewInterface{
	@Reference
	private DBinterface daoService;
	@Override
	public List<User> getAllUser(String find) {
		// TODO Auto-generated method stub
		return daoService.getAllUser(find);
	}
}
