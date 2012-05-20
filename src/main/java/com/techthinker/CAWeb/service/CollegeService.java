package com.techthinker.CAWeb.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techthinker.CAWeb.exception.CollegeException;
import com.techthinker.CAWeb.idao.ICollegeDao;
import com.techthinker.CAWeb.iservice.ICollegeService;
import com.techthinker.CAWeb.util.PageObject;
import com.techthinker.CAWeb.vo.College;

@Service("collegeService")
public class CollegeService implements ICollegeService {

	private ICollegeDao collegeDao;
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
		if(tc!=null) throw new CollegeException("要添加的学院已经存在，不能添加");
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
		if(collegeName==null||"".equals(collegeName.trim())) {
			return collegeDao.find("from College");
		} else {
			return collegeDao.find("from College where collegeName like ?",
					new Object[]{"%"+collegeName+"%"});
		}
	}

	@Override
	public College loadByCollegename(String collegeName) {
		return collegeDao.loadByHql("from College where majorName=?",collegeName);
	}

	@Override
	public boolean checkCollege(String collegeName) {
		long count = (Long)collegeDao.loadObjByHQL("select count(*) from College where collegeName=?",collegeName);
		return count>0?true:false;
	}

	@Override
	public void addCollegeFromInputStream(InputStream inputStream)
			throws IOException {
		// TODO Auto-generated method stub

	}

}
