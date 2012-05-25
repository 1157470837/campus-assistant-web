package com.techthinker.CAWeb.test;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;

import com.techthinker.CAWeb.iservice.ICollegeService;

public class TestCollegeService {

	private static BeanFactory factory;
	private static ICollegeService collegeService;
	
	@BeforeClass
	public static void init() {
//		factory = new ClassPathXmlApplicationContext("beans.xml");
//		collegeService = (ICollegeService)factory.getBean("collegeService");
	}
	
	@Test
	public void testAdd() {
//		College c = new College();
//		c.setCollegeName("信息科学与工程学院");
//		c.setDescription("信息科学与工程学院是山东科技大学中优秀的学院之一，师资力量强，研发能力强，现有设备齐全。");
//		collegeService.add(c);
	}
	
	@Test
	public void testAddCollegeFromInputStream(){
//		InputStream inputStream = this
//				.getClass()
//				.getClassLoader()
//				.getResourceAsStream("collegeInfo.txt");
//		try {
//			collegeService.addCollegeFromInputStream(inputStream);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
