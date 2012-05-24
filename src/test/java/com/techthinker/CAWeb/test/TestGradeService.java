package com.techthinker.CAWeb.test;

import java.io.IOException;
import java.io.InputStream;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techthinker.CAWeb.iservice.IGradeService;

public class TestGradeService {

	private static BeanFactory factory;
	private static IGradeService gradeService;

	@BeforeClass
	public static void init() {
//		factory = new ClassPathXmlApplicationContext("beans.xml");
//		gradeService = (IGradeService) factory.getBean("gradeService");
	}

	@Test
	public void testAddGradeFromInputStream() {
//		InputStream inputStream = this.getClass().getClassLoader()
//				.getResourceAsStream("gradeInfo.txt");
//		try {
//			gradeService.addGradeFromInputStream(inputStream);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// fail("Not yet implemented");
	}

}
