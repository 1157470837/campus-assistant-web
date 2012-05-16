package com.techthinker.CAWeb.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
/**
 * application Session记录类，目前用于记录全局的Session操作
 * @author JC@Techthinker.com
 *
 */
public class CAWebSessionContext {
	private final static Map<String,HttpSession> sessions = new HashMap<String,HttpSession>();

	/**
	 * 添加session
	 * @param session
	 */
	public static synchronized void  addSession(HttpSession session) {
		if(session!=null) {
			sessions.put(session.getId(), session);
			System.out.println("添加了session:"+session.getId());
		}
	}
	
	/**
	 * 移除session
	 * @param sessionId
	 */
	public static synchronized void  removeSession(String sessionId) {
		if(sessionId!=null) {
			sessions.remove(sessionId);
			System.out.println("移除了session:"+sessionId);
		}
	}
	
	/**
	 * 获取session
	 * @param sessionId
	 * @return
	 */
	public static HttpSession getSession(String sessionId) {
		return sessions.get(sessionId);
	}
}
