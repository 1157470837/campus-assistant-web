package com.techthinker.CAWeb.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

/**
 * 请求响应工具类
 * @author JC@Techthinker.com
 *
 */
public class ActionUtil {
	//公告列表信息标识
	public final static String NEWS_LIST = "news_list";
	//重定向标识
	public final static String REDIRECT = "redirect";
	
	/**
	 * 将obj转化成json格式的数据，并写入response到客户端
	 * @param obj 
	 * @param response
	 * @throws IOException
	 */
	public static void sendJson(Object obj,HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		String json = JsonJacksonUtil.getInstance().obj2json(obj);
		response.getWriter().write(json);
	}
}	
