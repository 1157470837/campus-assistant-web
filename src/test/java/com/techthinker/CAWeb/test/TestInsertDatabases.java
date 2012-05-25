package com.techthinker.CAWeb.test;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techthinker.CAWeb.iservice.ICampusnewsService;
import com.techthinker.CAWeb.iservice.IChatroomService;
import com.techthinker.CAWeb.iservice.ICollegeService;
import com.techthinker.CAWeb.iservice.IGradeService;
import com.techthinker.CAWeb.iservice.IMajorService;
import com.techthinker.CAWeb.iservice.IMessageService;
import com.techthinker.CAWeb.iservice.IScenicspotService;
import com.techthinker.CAWeb.iservice.IUserService;
import com.techthinker.CAWeb.iservice.IUsertypeService;

public class TestInsertDatabases {
	private static BeanFactory factory;
	private static IScenicspotService scenicspotService;
	private static ICollegeService collegeService;
	private static IGradeService gradeService;
	private static IMajorService majorService;
	private static ICampusnewsService campusnewsService;
	private static IChatroomService chatroomService;
	private static IMessageService messageService;
	private static IUsertypeService usertypeService;
	private static IUserService userService;


	@BeforeClass
	public static void init() {
		factory = new ClassPathXmlApplicationContext("beans.xml");
		scenicspotService = (IScenicspotService) factory
				.getBean("scenicspotService");
		collegeService = (ICollegeService) factory.getBean("collegeService");
		majorService = (IMajorService) factory.getBean("majorService");
		gradeService = (IGradeService) factory.getBean("gradeService");
		campusnewsService = (ICampusnewsService)factory.getBean("campusnewsService");
		usertypeService = (IUsertypeService)factory.getBean("usertypeService");
		userService = (IUserService)factory.getBean("userService");
		chatroomService = (IChatroomService) factory.getBean("chatroomService");
		messageService = (IMessageService) factory.getBean("messageService");
	}

	@Test
	public void testInsert() {
		try {
			scenicspotService.addScenicspotsFromInputStream(this.getClass()
					.getClassLoader().getResourceAsStream("scenicspots.txt"));
			collegeService.addCollegeFromInputStream(this.getClass()
					.getClassLoader().getResourceAsStream("collegeInfo.txt"));
			majorService.addMajorFromInputStream(this.getClass()
					.getClassLoader().getResourceAsStream("majorInfo.txt"));
			gradeService.addGradeFromInputStream(this.getClass()
					.getClassLoader().getResourceAsStream("gradeInfo.txt"));
			usertypeService.addUsertypeFromInputStream(this.getClass().getClassLoader()
					.getResourceAsStream("usertypeInfo.txt"));
			userService.addUserFromInputStream(this.getClass().getClassLoader()
					.getResourceAsStream("userInfo.txt"));
			campusnewsService.addCampusnewsFromInputStream(this.getClass().getClassLoader()
					.getResourceAsStream("campusnewsInfo.txt"));
			chatroomService.addChatroomFromInputStream(this.getClass().getClassLoader()
					.getResourceAsStream("chatroomInfo.txt"));
			messageService.addMessageFromInputStream(this.getClass().getClassLoader()
					.getResourceAsStream("messageInfo.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
