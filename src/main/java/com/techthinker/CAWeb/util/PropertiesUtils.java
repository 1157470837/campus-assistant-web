package com.techthinker.CAWeb.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * properties工具类
 * @author JC@Techthinker.com
 *
 */
public class PropertiesUtils {
	private static Properties jdbcProperties;
	private static Properties daoProperties;
	private static Map<String,Properties> maps = new HashMap<String, Properties>();
	
	/**
	 * 使用map来实现第二种单例模式，读取properties并放入map中
	 * @param name 要读取的properties的名称
	 * @return properties对象
	 */
	public static Properties createProperties(String name) {
		if(maps.get(name)!=null) {
			return maps.get(name);
		} else {
			Properties properties = new Properties();
			try {
				properties.load(PropertiesUtils.class
						.getClassLoader()
						.getResourceAsStream(name+".properties"));
			} catch (IOException e) {
				return null;
			}
			maps.put(name,properties);
			return properties;
		}
	}
	
	/**
	 * 用单例模式读取jdbc.properties
	 * @return
	 */
	public static Properties createJDBCProperties() {
		if(jdbcProperties==null) {
			jdbcProperties = new Properties();
			try {
				jdbcProperties.load(PropertiesUtils.class
						.getClassLoader()
						.getResourceAsStream("jdbc.properties"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			return jdbcProperties;
		} else {
			return jdbcProperties;
		}
	}
	
	/**
	 * 用单例模式读取dao.properties
	 * @return
	 */
	public static Properties createDaoProperties() {
		if(daoProperties==null) {
			daoProperties = new Properties();
			try {
				daoProperties.load(PropertiesUtils.class
						.getClassLoader()
						.getResourceAsStream("dao.properties"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			return daoProperties;
		} else {
			return daoProperties;
		}
	}
}
