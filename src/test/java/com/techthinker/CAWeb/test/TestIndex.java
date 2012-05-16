//package com.techthinker.CAWeb.test;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.springframework.beans.factory.BeanFactory;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.techthinker.CAWeb.iservice.IIndexService;
//import com.techthinker.CAWeb.util.SystemContext;
//
//public class TestIndex {
//	private static BeanFactory factory;
//	private static IIndexService indexService;
//	
//	@BeforeClass
//	public static void init() {
//		factory = new ClassPathXmlApplicationContext("beans.xml");
//		indexService = (IIndexService)factory.getBean("indexService");
//	}
//	
//	@Test
//	public void testReconstructor() {
//		SystemContext.setRealPath("D:/kh/j2ee/msg_myeclipse/message4_2/WebRoot");
//		indexService.updateReconstructorIndex();
////		indexService.updateSetIndex();
//	}
//}
