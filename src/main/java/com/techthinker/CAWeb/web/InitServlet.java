package com.techthinker.CAWeb.web;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.techthinker.CAWeb.util.AuthUtil;

/**
 * application启动时，先对其进行自定义初始化，目前为加载权限配置并保持到application的context中
 * @author JC@Techthinker.com
 *
 */
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = -24818954054590594L;
	
	/**
	 * 初始化application，加载权限配置
	 */
	@Override
	public void init() throws ServletException {
		Map<Integer,List<String>> auths = AuthUtil.initAuth();
		System.out.println("****************系统初始化完毕***********************");
		System.out.println(auths);
		//将 对象存储到servletContext(application)
		this.getServletContext().setAttribute("auths",auths);
		super.init();
	}
}
