package com.techthinker.CAWeb.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techthinker.CAWeb.idao.ICampusnewsDao;
import com.techthinker.CAWeb.iservice.ICampusnewsService;
import com.techthinker.CAWeb.util.PageObject;
import com.techthinker.CAWeb.vo.Campusnews;

@Service("campusnewsService")
public class CampusnewsService implements ICampusnewsService {

	private ICampusnewsDao campusnewsDao;
	public ICampusnewsDao getCampusnewsDao() {
		return campusnewsDao;
	}

	@Resource
	public void setCampusnewsDao(ICampusnewsDao campusnewsDao) {
		this.campusnewsDao = campusnewsDao;
	}

	@Override
	public void add(Campusnews campusnews) {
		this.campusnewsDao.add(campusnews);

	}

	@Override
	public void update(Campusnews campusnews) {
		this.update(campusnews);

	}

	@Override
	public void delete(int id) {
		this.campusnewsDao.delete(id);

	}

	@Override
	public Campusnews load(int id) {
		return this.campusnewsDao.load(id);
	}

	@Override
	public List<Campusnews> list() {
		return this.campusnewsDao.list("from Campusnews");
	}

	@Override
	public PageObject<Campusnews> find(int newstype, Date pubdate, int userId,
			int collegeId, int majorId, int level) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCollegeFromInputStream(InputStream inputStream)
			throws IOException {
		// TODO Auto-generated method stub

	}

}
