package com.techthinker.CAWeb.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techthinker.CAWeb.idao.ICampusnewsDao;
import com.techthinker.CAWeb.idao.IUserDao;
import com.techthinker.CAWeb.iservice.ICampusnewsService;
import com.techthinker.CAWeb.util.PageObject;
import com.techthinker.CAWeb.vo.Campusnews;
import com.techthinker.CAWeb.vo.User;

@Service("campusnewsService")
public class CampusnewsService implements ICampusnewsService {

	private ICampusnewsDao campusnewsDao;
	private IUserDao userDao;

	public IUserDao getUserDao() {
		return userDao;
	}

	@Resource
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

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
	public void addCampusnewsFromInputStream(InputStream inputStream)
			throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				inputStream));
		String r = br.readLine();
		Campusnews cn = null;
		User user = null;
		
		r = br.readLine();
		while( r!=null ){
			if(r.contains("----------")){
				r = br.readLine();
			}
			cn = new Campusnews();
			cn.setNewstype(Integer.parseInt(r.trim()));
			cn.setContent(br.readLine().trim());
			cn.setPubdate(Timestamp.valueOf(br.readLine().trim()+" 00:00:00"));
			user = userDao.loadByHql("from User where username = ?",br.readLine().trim());		
			cn.setUser(user);
			cn.setMajor(user.getMajor());
			cn.setCollege(user.getCollege());
			cn.setLevel(Integer.parseInt(br.readLine().trim()));
			
			campusnewsDao.add(cn);

			r = br.readLine();
		}

	}

}
