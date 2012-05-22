package com.techthinker.CAWeb.web;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.techthinker.CAWeb.iservice.IIndexService;
import com.techthinker.CAWeb.util.SystemContext;
/**
 * application清理监听器类，当创建ServletContext时激发，目前用于Service的异步更新功能
 * @author JC@Techthinker.com
 *
 */
public class CleanListener implements ServletContextListener {
	private Timer timer;
	private Timer indexTimer;
	private WebApplicationContext wac = null;
	private String realPath=null;
	
	/**
	 * 设置realPath，初始化定时任务
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		wac = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		System.out.println("------------------清理的启动程序已经开启（已经获取了"+wac+"）---------------------");
		realPath = sce.getServletContext().getRealPath("");
		timer = new Timer();
		timer.scheduleAtFixedRate(new ClearDataTask(),50000, 300000);
		indexTimer = new Timer();
		indexTimer.scheduleAtFixedRate(new IndexCommit(), 600000, 600000);
	}
	
	/**
	 * 异步更新数据
	 * @author JC@Techthinker.com
	 *
	 */
	private class ClearDataTask extends TimerTask {
		//可以获取spring中BeanFactory,这个BeanFactory是在系统启动的时候就完成了存储
		@Override
		public void run() {
			//对线程创建SystemContext对象，并设置realPath
			SystemContext.setRealPath(realPath);
			System.out.println("进行了清理"+new Date());
//			IAttachmentService attachmentService = (IAttachmentService)wac.getBean("attachmentService");
//			attachmentService.updateClearAttach();
		}
	}
	
	/**
	 * 异步更新索引
	 * @author JC@Techthinker.com
	 *
	 */
	private class IndexCommit extends TimerTask {
		@Override
		public void run() {
			SystemContext.setRealPath(realPath);
			System.out.println("索引进行了提交"+new Date());
			IIndexService indexService = (IIndexService)wac.getBean("indexService");
			indexService.updateCommitIndex();
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("--------------清理程序已经关闭-------------------");
		if(timer!=null) timer.cancel();
		if(indexTimer!=null) timer.cancel();
	}
}
