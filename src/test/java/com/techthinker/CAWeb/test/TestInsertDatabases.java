package com.techthinker.CAWeb.test;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techthinker.CAWeb.iservice.ICollegeService;
import com.techthinker.CAWeb.iservice.IGradeService;
import com.techthinker.CAWeb.iservice.IMajorService;
import com.techthinker.CAWeb.iservice.IScenicspotService;

public class TestInsertDatabases {
	private static BeanFactory factory;
	private static IScenicspotService scenicspotService;
	private static ICollegeService collegeService;
	private static IGradeService gradeService;
	private static IMajorService majorService;

	@BeforeClass
	public static void init() {
//		factory = new ClassPathXmlApplicationContext("beans.xml");
//		scenicspotService = (IScenicspotService) factory
//				.getBean("scenicspotService");
//		collegeService = (ICollegeService) factory.getBean("collegeService");
//		majorService = (IMajorService) factory.getBean("majorService");
//		gradeService = (IGradeService) factory.getBean("gradeService");
	}

	@Test
	public void testInsert() {
//		try {
//			scenicspotService.addScenicspotsFromInputStream(this.getClass()
//					.getClassLoader().getResourceAsStream("scenicspots.txt"));
//			collegeService.addCollegeFromInputStream(this.getClass()
//					.getClassLoader().getResourceAsStream("collegeInfo.txt"));
//			majorService.addMajorFromInputStream(this.getClass()
//					.getClassLoader().getResourceAsStream("majorInfo.txt"));
//			gradeService.addGradeFromInputStream(this.getClass()
//					.getClassLoader().getResourceAsStream("gradeInfo.txt"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}
