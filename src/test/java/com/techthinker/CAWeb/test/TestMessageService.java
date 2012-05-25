package com.techthinker.CAWeb.test;

import java.io.IOException;
import java.io.InputStream;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techthinker.CAWeb.iservice.IMessageService;

public class TestMessageService {

	private static BeanFactory factory;
	private static IMessageService messageService;

	@BeforeClass
	public static void init() {
//		factory = new ClassPathXmlApplicationContext("beans.xml");
//		messageService = (IMessageService) factory.getBean("messageService");
	}

	@Test
	public void testFind() {
		// fail("Not yet implemented");
	}

	@Test
	public void testAddMessageFromInputStream() {
//		InputStream inputStream = this.getClass().getClassLoader()
//				.getResourceAsStream("messageInfo.txt");
//		try {
//			messageService.addMessageFromInputStream(inputStream);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
