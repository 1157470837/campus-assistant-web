package com.techthinker.CAWeb.webservice;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.techthinker.CAWeb.iservice.IUserService;
import com.techthinker.CAWeb.iwebservice.IHelloWorld;
import com.techthinker.CAWeb.persistence.User;

@Component("sayHelloService")
public class HelloWorldWebservice implements IHelloWorld {
	private IUserService userService;

	/**
	 * @return the userSerice
	 */
	public IUserService getUserSerice() {
		return userService;
	}

	/**
	 * @param userSerice the userSerice to set
	 */
	@Resource
	public void setUserSerice(IUserService userSerice) {
		this.userService = userSerice;
	}

	@Override
	public String sayHello(String name, String macId) {
		return userService.loadByUsername(name).getDescription();
	}

	@Override
	public boolean register(User user) {
		userService.checkUser(user.getUsername());
		return false;
	}
	
}