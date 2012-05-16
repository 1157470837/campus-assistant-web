package com.techthinker.CAWeb.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * CAWeb项目工具类，用于封装常用方法
 * @author JC@Techthinker.com
 *
 */
public class CAWebUtil {
	/**
	 * 根据模板对日期进行格式化
	 * @param pattern 所要转化的模板
	 * @param date 被转化的日期
	 * @return 格式化的日期
	 */
	public static String formatDate(String pattern,Date date) {
		String str = null;
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);//MM/dd hh:ss
		str = sdf.format(date);
		return str;
	}
}
