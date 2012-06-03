package com.techthinker.CAWeb.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techthinker.CAWeb.exception.CollegeException;
import com.techthinker.CAWeb.idao.ICollegeDao;
import com.techthinker.CAWeb.idao.IScenicspotDao;
import com.techthinker.CAWeb.idao.ITempIndexDao;
import com.techthinker.CAWeb.iservice.ICollegeService;
import com.techthinker.CAWeb.persistence.College;
import com.techthinker.CAWeb.persistence.Scenicspot;
import com.techthinker.CAWeb.persistence.TempIndex;
import com.techthinker.CAWeb.util.IndexUtil;
import com.techthinker.CAWeb.util.PageObject;

@Service("collegeService")
public class CollegeService implements ICollegeService {

	private ICollegeDao collegeDao;
	private IScenicspotDao scenicspotDao;
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

	public IScenicspotDao getScenicspotDao() {
		return scenicspotDao;
	}

	@Resource
	public void setScenicspotDao(IScenicspotDao scenicspotDao) {
		this.scenicspotDao = scenicspotDao;
	}

	public ICollegeDao getCollegeDao() {
		return collegeDao;
	}

	@Resource
	public void setCollegeDao(ICollegeDao collegeDao) {
		this.collegeDao = collegeDao;
	}

	@Override
	public void add(College college) {
		College tc = loadByCollegename(college.getCollegeName());
		if (tc != null)
			throw new CollegeException("要添加的学院已经存在，不能添加");
		collegeDao.add(college);

	}

	@Override
	public void update(College college) {
		this.collegeDao.update(college);

	}

	@Override
	public void delete(int id) {
		this.collegeDao.delete(id);

	}

	@Override
	public College load(int id) {
		return this.collegeDao.load(id);
	}

	@Override
	public List<College> list() {
		return this.collegeDao.list("from College");
	}

	@Override
	public PageObject<College> find(String collegeName) {
		if (collegeName == null || "".equals(collegeName.trim())) {
			return collegeDao.find("from College");
		} else {
			return collegeDao.find("from College where collegeName like ?",
					new Object[] { "%" + collegeName + "%" });
		}
	}

	@Override
	public College loadByCollegename(String collegeName) {
		return collegeDao.loadByHql("from College where majorName=?",
				collegeName);
	}

	@Override
	public boolean checkCollege(String collegeName) {
		long count = (Long) collegeDao
				.loadObjByHQL(
						"select count(*) from College where collegeName=?",
						collegeName);
		return count > 0 ? true : false;
	}

	@Override
	public void addCollegeFromInputStream(InputStream inputStream)
			throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				inputStream));
		String r = br.readLine();
		r = br.readLine();
		while (r != null && r.contains("----------")) {
			College c = new College();
			c.setCollegeName(br.readLine().trim());
			c.setDescription(br.readLine().trim());
			String spotName = br.readLine().trim();
			Scenicspot scenicspot = scenicspotDao.loadByHql(
					"from Scenicspot where spotname=?", spotName);
			c.setScenicspot(scenicspot);
			collegeDao.add(c);
			TempIndex tempIndex = new TempIndex();
			tempIndex.setAdd();
			tempIndex.setObjId(c.getCollegeId());
			tempIndex.setObjType(IndexUtil.ACTION_COLLEGE);
			tempIndexDao.add(tempIndex);

			r = br.readLine();
		}

	}

}
