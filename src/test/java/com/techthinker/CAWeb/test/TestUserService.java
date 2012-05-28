package com.techthinker.CAWeb.test;

import java.io.IOException;
import java.io.InputStream;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techthinker.CAWeb.iservice.IUserService;

public class TestUserService {

	private static BeanFactory factory;
	private static IUserService userService;
	
//	@BeforeClass
//	public static void init() {
//		factory = new ClassPathXmlApplicationContext("beans.xml");
//		userService = (IUserService)factory.getBean("userService");
//	}
//	
//	@Test
//	public void testAddUserFromInputStream() {
//		InputStream inputStream = this.getClass().getClassLoader()
//				.getResourceAsStream("userInfo.txt");
//		try {
//			userService.addUserFromInputStream(inputStream);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// fail("Not yet implemented");
//	}

}
