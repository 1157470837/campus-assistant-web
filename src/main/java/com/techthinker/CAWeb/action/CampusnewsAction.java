package com.techthinker.CAWeb.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.techthinker.CAWeb.iservice.ICampusnewsService;
import com.techthinker.CAWeb.persistence.Campusnews;

@Controller("campusnewsAction")
@Scope("prototype")
public class CampusnewsAction extends ActionSupport implements ModelDriven<Campusnews>{
	private static final long serialVersionUID = -3266057605774486873L;

	private ICampusnewsService campusnewsService;
	private List<Campusnews> campusnewsList;
	
	public List<Campusnews> getCampusnewsList() {
		return campusnewsList;
	}
	public void setCampusnewsList(List<Campusnews> campusnewsList) {
		this.campusnewsList = campusnewsList;
	}
	public ICampusnewsService getCampusnewsService() {
		return campusnewsService;
	}
	
	@Resource
	public void setCampusnewsService(ICampusnewsService campusnewsService) {
		this.campusnewsService = campusnewsService;
	}
	
	/**
	 * 处理校园公告信息
	 * @return
	 */
	public String listcampusNotif(){
		campusnewsList = campusnewsService.listCampusNotif();
		return SUCCESS;
	}
	
	/**
	 * 处理学院公告信息
	 * @return
	 */
	public String listcollegeNotif(){
		campusnewsList = campusnewsService.listCollegeNotif();
		return SUCCESS;
	}
	
	/**
	 * 处理校园新闻
	 * @return
	 */
	public String listNews(){
		campusnewsList = campusnewsService.listNews();
		return SUCCESS;
	}
	
	/**
	 * 处理搜索信息
	 * @return
	 */
	public String searchInfo(){
		campusnewsList = campusnewsService.list();
		return SUCCESS;
	}
	
	@Override
	public Campusnews getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
