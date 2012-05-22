package com.techthinker.CAWeb.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techthinker.CAWeb.iservice.IUserService;
import com.techthinker.CAWeb.service.UserService;
import com.techthinker.CAWeb.vo.User;
import com.techthinker.CAWeb.vo.Usertype;

public class TestUserService {

	private static BeanFactory factory;
	private static IUserService userService;
	
	@BeforeClass
	public static void init() {
		factory = new ClassPathXmlApplicationContext("beans.xml");
		userService = (UserService)factory.getBean("userService");
	}
	
//	@Test
//	public void testAdd() {
//		User user = new User();
//		user.setUsername("admin");
//		user.setUsertype(new Usertype(3));
//		userService.add(user);
//	}
//
//	@Test
//	public void testUpdate() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDelete() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testLoad() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testList() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testLogin() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testFind() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testLoadByUsername() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testCheckUser() {
//		fail("Not yet implemented");
//	}

}
