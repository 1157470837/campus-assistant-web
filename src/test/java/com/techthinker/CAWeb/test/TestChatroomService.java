package com.techthinker.CAWeb.test;

import java.io.IOException;
import java.io.InputStream;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techthinker.CAWeb.iservice.IChatroomService;

public class TestChatroomService {

	private static BeanFactory factory;
	private static IChatroomService chatroomService;

	@BeforeClass
	public static void init() {
//		factory = new ClassPathXmlApplicationContext("beans.xml");
//		chatroomService = (IChatroomService) factory.getBean("chatroomService");
	}

	@Test
	public void testAddCollegeFromInputStream() {
//		InputStream inputStream = this.getClass().getClassLoader()
//				.getResourceAsStream("chatroomInfo.txt");
//		try {
//			chatroomService.addCollegeFromInputStream(inputStream);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
