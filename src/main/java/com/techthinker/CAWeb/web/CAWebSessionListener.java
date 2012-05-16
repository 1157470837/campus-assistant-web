package com.techthinker.CAWeb.web;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 * application Session操作监听器类，当更改一个Session时激发，目前用于记录全局的Session
 * @author JC@Techthinker.com
 *
 */
public class CAWebSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent hse) {
		CAWebSessionContext.addSession(hse.getSession());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent hse) {
		CAWebSessionContext.removeSession(hse.getSession().getId());
	}

}
