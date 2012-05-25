package com.techthinker.CAWeb.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;

import com.techthinker.CAWeb.iservice.IMajorService;

public class TestMajorService {

	private static BeanFactory factory;
	private static IMajorService majorService;

	@BeforeClass
	public static void init() {
//		factory = new ClassPathXmlApplicationContext("beans.xml");
//		majorService = (IMajorService) factory.getBean("majorService");
	}

	@Test
	public void testAddMajorFromInputStream() {
//		InputStream inputStream = this.getClass().getClassLoader()
//				.getResourceAsStream("majorInfo.txt");
//		try {
//			majorService.addMajorFromInputStream(inputStream);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
