package com.techthinker.CAWeb.test;

import java.io.IOException;
import java.io.InputStream;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techthinker.CAWeb.iservice.IUsertypeService;

public class TestUsertypeService {
	private static BeanFactory factory;
	private static IUsertypeService usertypeService;
	
	@BeforeClass
	public static void init() {
//		factory = new ClassPathXmlApplicationContext("beans.xml");
//		usertypeService = (IUsertypeService)factory.getBean("usertypeService");
	}
	
	@Test
	public void testAddUserFromInputStream() {
//		InputStream inputStream = this.getClass().getClassLoader()
//				.getResourceAsStream("usertypeInfo.txt");
//		try {
//			usertypeService.addUsertypeFromInputStream(inputStream);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// fail("Not yet implemented");
	}

}
