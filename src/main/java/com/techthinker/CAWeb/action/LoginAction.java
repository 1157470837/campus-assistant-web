package com.techthinker.CAWeb.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.techthinker.CAWeb.iservice.IUserService;
import com.techthinker.CAWeb.persistence.User;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = -2934347040666877652L;
	
	private String username;
	private String password;
	
	private IUserService userService;
	
	private String msg;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public IUserService getUserService() {
		return userService;
	}
	@Resource
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * 用户登入
	 * 
	 * @return
	 */
	public String login() {
		User u = null;
		if (username != "" && password != "") {
			try {
				u = userService.login(username, password);
				if (u != null) {
					ActionContext.getContext().getSession()
							.put("username",u.getUsername());
					ActionContext.getContext().getSession()
					.put("usertype",u.getUsertype());
					return "loginOk";
				}

			} catch (Exception e) {
				msg = "您填写信息的信息有误，请核对后再登入！";
				return "loginFailure";
			}
		}
		msg = "您填写信息的信息有误，请核对后再登入！";
		return "loginFailure";

	}
}
