//package com.techthinker.CAWeb.test;
//
//import org.springframework.beans.factory.BeanFactory;
//
//
//public class TestDao {
//	private static BeanFactory factory;
//	private static IUserDao userDao;
//	
//	@BeforeClass
//	public static void init() {
//		factory = new ClassPathXmlApplicationContext("beans.xml");
//		userDao = (IUserDao)factory.getBean("userDao");
//	}
//	
//	@Test
//	public void testUserList() {
//		List<User> users = userDao.list("from User where nickname like ?",new Object[]{"%张%"});
//		for(User u:users) {
//			System.out.println(u.getNickname());
//		}
//	}
//	
//	@Test
//	public void testAddUser() {
//		User u = new User();
//		u.setUsername("sssdfsdf");
//		userDao.add(u);
//	}
//	@Test
//	public void load() {
//		User u = userDao.load(1);
//		System.out.println(u.getNickname());
//	}
//}
