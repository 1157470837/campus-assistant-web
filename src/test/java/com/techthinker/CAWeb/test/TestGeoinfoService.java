package com.techthinker.CAWeb.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;

import com.techthinker.CAWeb.iservice.IGeoinfoService;


public class TestGeoinfoService {
	private static BeanFactory factory;
	private static IGeoinfoService geoinfoService;
	
	@BeforeClass
	public static void init() {
//		factory = new ClassPathXmlApplicationContext("beans.xml");
//		geoinfoService = (IGeoinfoService)factory.getBean("geoinfoService");
	}
	
	@Test
	public void testPushGeoinfos() {
//		try {
//			geoinfoService.addGeoinfosFromInputStream(this.getClass().getClassLoader().getResourceAsStream("scenicspots.txt"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}
