package com.techthinker.CAWeb.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techthinker.CAWeb.iservice.ICampusnewsService;

public class TestCampusService {

	private static BeanFactory factory;
	private static ICampusnewsService campusnewsService;
	
	@BeforeClass
	public static void init() {
//		factory = new ClassPathXmlApplicationContext("beans.xml");
//		campusnewsService = (ICampusnewsService)factory.getBean("campusnewsService");
	}
	@Test
	public void testFind() {
		//fail("Not yet implemented");
	}

	@Test
	public void testAddCollegeFromInputStream() {
//		InputStream inputStream = this.getClass().getClassLoader()
//				.getResourceAsStream("campusnewsInfo.txt");
//		try {
//			campusnewsService.addCollegeFromInputStream(inputStream);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

}
