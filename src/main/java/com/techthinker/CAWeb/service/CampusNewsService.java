package com.techthinker.CAWeb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techthinker.CAWeb.iservice.ICampusNewsService;
import com.techthinker.CAWeb.util.PageObject;
import com.techthinker.CAWeb.vo.CampusNews;

@Service("messageService")
public class CampusNewsService implements ICampusNewsService {

	@Override
	public void add(CampusNews m, int userId, Integer[] atts) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CampusNews m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CampusNews load(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CampusNews> listByTitle(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CampusNews> listByContent(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageObject<CampusNews> findByTitle(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageObject<CampusNews> findByContent(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CampusNews> listByUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageObject<CampusNews> findByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
