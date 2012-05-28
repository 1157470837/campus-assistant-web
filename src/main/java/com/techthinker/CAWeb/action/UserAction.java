package com.techthinker.CAWeb.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.techthinker.CAWeb.iservice.IUserService;
import com.techthinker.CAWeb.vo.User;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User>{

	private static final long serialVersionUID = 9129984683671574490L;

	private User user;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private IUserService userService;
	
	public IUserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	/**
	 * 
	 * @return
	 */
	public String login(){
		return 	SUCCESS;
	}
	
	/**
	 * 
	 * @return
	 */
	public String register(){
		return SUCCESS;
	}
	
	@Override
	public User getModel() {
		if(user == null)
			user = new User();
		return user;
	}

}
