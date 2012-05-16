package com.techthinker.CAWeb.iservice;

import java.util.List;


import com.techthinker.CAWeb.util.PageObject;
import com.techthinker.CAWeb.vo.CampusNews;

public interface ICampusNewsService {
	
	public void add(CampusNews m, int userId,Integer[] atts);
	
	public void update(CampusNews m);
	
	public void delete(int id);
	
	public CampusNews load(int id);
	
	public List<CampusNews> listByTitle(String keyword);
	
	public List<CampusNews> listByContent(String keyword);
	
	public PageObject<CampusNews> findByTitle(String keyword);
	
	public PageObject<CampusNews> findByContent(String keyword);
	
	public List<CampusNews> listByUser(int userId);
	
	public PageObject<CampusNews> findByCondition(String condition);
}
