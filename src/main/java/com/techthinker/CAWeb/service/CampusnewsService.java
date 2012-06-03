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
import com.techthinker.CAWeb.idao.ITempIndexDao;
import com.techthinker.CAWeb.idao.IUserDao;
import com.techthinker.CAWeb.iservice.ICampusnewsService;
import com.techthinker.CAWeb.persistence.Campusnews;
import com.techthinker.CAWeb.persistence.College;
import com.techthinker.CAWeb.persistence.Major;
import com.techthinker.CAWeb.persistence.TempIndex;
import com.techthinker.CAWeb.persistence.User;
import com.techthinker.CAWeb.util.CAWebUtil;
import com.techthinker.CAWeb.util.IndexUtil;
import com.techthinker.CAWeb.util.PageObject;

@Service("campusnewsService")
public class CampusnewsService implements ICampusnewsService {

	private ICampusnewsDao campusnewsDao;
	private IUserDao userDao;
	private ITempIndexDao tempIndexDao;

	/**
	 * @return the tempIndexDao
	 */
	public ITempIndexDao getTempIndexDao() {
		return tempIndexDao;
	}

	/**
	 * @param tempIndexDao
	 *            the tempIndexDao to set
	 */
	@Resource
	public void setTempIndexDao(ITempIndexDao tempIndexDao) {
		this.tempIndexDao = tempIndexDao;
	}

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
	public PageObject<Campusnews> find(int type) {
		if (type >= 0 && type <= 2) {
			StringBuilder hql = new StringBuilder("from Campusnews");
			if (type != 0) {
				hql.append(" cn where cn.newstype = " + type);
			}
System.out.println(hql.toString());
			return campusnewsDao.find(hql.toString());
		} else {
			return null;
		}
	}

	
	@Override
	public List<Campusnews> listNews() {
		return campusnewsDao.list("from Campusnews cn where cn.newstype = 1");
	}

	@Override
	public List<Campusnews> listCollegeNotif() {
		return campusnewsDao.list("from Campusnews cn where cn.newstype = 2 and cn.level = 2");
	}

	@Override
	public List<Campusnews> listMajorNotif() {
		return campusnewsDao.list("from Campusnews cn where cn.newstype = 2 and cn.level = 3");
	}

	@Override
	public List<Campusnews> listNotif() {
		return campusnewsDao.list("from Campusnews cn where cn.newstype = 2");
	}

	@Override
	public List<Campusnews> listCampusNotif() {
		return campusnewsDao.list("from Campusnews cn where cn.newstype = 2 and cn.level = 1");
	}

	@Override
	public PageObject<Campusnews> findByDate(Date start, Date end, int type) {
		if (type >= 0 && type <= 2) {
			Timestamp tStart, tEnd;
			StringBuilder hql = new StringBuilder("from Campusnews cn");
			if (type != 0) {
				hql.append(" where cn.newstype = " + type);
			}
			if(start == null){
				start = new Date(1900,1,1);
			}
			if(end == null){
				end = new Date(2999,12,30);
			}
			if (! end.after(start)){
				start = new Date(1900,1,1);
				end = new Date(2999,12,30);
			}
			
			tStart = Timestamp.valueOf(CAWebUtil.formatDate("yy-MM-dd", start) + " 00:00:00");
			tEnd = Timestamp.valueOf(CAWebUtil.formatDate("yy-MM-dd", end) + " 23:59:59");
			
			hql.append(" and pubdate > ? and pubdate < ?");
			
			return campusnewsDao.find(hql.toString(), new Object[]{tStart,tEnd});
		} else {
			return null;
		}
	}

	@Override
	public PageObject<Campusnews> findByCollege(College college, int type) {
		if (type >= 0 && type <= 2) {
			StringBuilder hql = new StringBuilder("from Campusnews cn");
			if (type != 0) {
				hql.append(" where cn.newstype = " + type);
			}
			if(college.getCollegeId() != null){
				hql.append(" and cn.college.collgeId = " + college.getCollegeId());
			}
			return campusnewsDao.find(hql.toString());
		} else {
			return null;
		}
	}

	@Override
	public PageObject<Campusnews> findByMajor(Major major, int type) {
		if (type >= 0 && type <= 2) {
			StringBuilder hql = new StringBuilder("from Campusnews cn");
			if (type != 0) {
				hql.append(" where cn.newstype = " + type);
			}
			if(major.getMajorId() != null){
				hql.append(" and cn.major.majorId = " + major.getMajorId());
			}
			return campusnewsDao.find(hql.toString());
		} else {
			return null;
		}
	}

	@Override
	public PageObject<Campusnews> findNews() {
		return campusnewsDao.find("from Campusnews cn where cn.newstype = 1");
	}

	@Override
	public PageObject<Campusnews> findNotification() {
		return campusnewsDao.find("from Campusnews cn where cn.newstype = 2");
	}

	@Override
	public PageObject<Campusnews> findByUserID(int id, int type) {
		if (type >= 0 && type <= 2) {
			StringBuilder hql = new StringBuilder("from Campusnews cn");
			if (type != 0) {
				hql.append(" where cn.newstype = " + type);
			}
			if(id > 0){
				hql.append(" and cn.campusnewId = " + id);
			}
			return campusnewsDao.find(hql.toString());
		} else {
			return null;
		}
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
		while (r != null) {
			if (r.contains("----------")) {
				r = br.readLine();
			}
			cn = new Campusnews();
			cn.setNewstype(Integer.parseInt(r.trim()));
			cn.setContent(br.readLine().trim());
			cn.setPubdate(Timestamp.valueOf(br.readLine().trim() + " 00:00:00"));
			user = userDao.loadByHql("from User where username = ?", br
					.readLine().trim());
			cn.setUser(user);
			cn.setMajor(user.getMajor());
			cn.setCollege(user.getCollege());
			cn.setLevel(Integer.parseInt(br.readLine().trim()));

			campusnewsDao.add(cn);
			TempIndex tempIndex = new TempIndex();
			tempIndex.setAdd();
			tempIndex.setObjId(cn.getCampusnewId());
			tempIndex.setObjType(IndexUtil.ACTION_CAMPUSNEWS);
			tempIndexDao.add(tempIndex);

			r = br.readLine();
		}

	}

}
