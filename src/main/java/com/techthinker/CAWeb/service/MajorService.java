package com.techthinker.CAWeb.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techthinker.CAWeb.exception.MajorException;
import com.techthinker.CAWeb.idao.IMajorDao;
import com.techthinker.CAWeb.iservice.IMajorService;
import com.techthinker.CAWeb.util.PageObject;
import com.techthinker.CAWeb.vo.Major;

@Service("majorService")
public class MajorService implements IMajorService {

	private IMajorDao majorDao;
	
	public IMajorDao getMajorDao() {
		return majorDao;
	}

	@Resource
	public void setMajorDao(IMajorDao majorDao) {
		this.majorDao = majorDao;
	}

	@Override
	public void add(Major major) {
		Major tm = loadByMajorname(major.getMajorName());
		if(tm!=null) throw new MajorException("要添加的专业已经存在，不能添加");
		majorDao.add(major);
	}

	@Override
	public void update(Major major) {
		this.majorDao.update(major);
	}

	@Override
	public void delete(int id) {
		this.majorDao.delete(id);

	}

	@Override
	public Major load(int id) {
		return this.majorDao.load(id);
	}

	@Override
	public List<Major> list() {
		return this.majorDao .list("from Major");
	}

	@Override
	public PageObject<Major> find(String majorName) {
		if(majorName==null||"".equals(majorName.trim())) {
			return majorDao.find("from Major");
		} else {
			return majorDao.find("from Major where majorName like ?",
					new Object[]{"%"+majorName+"%"});
		}
	}

	@Override
	public Major loadByMajorname(String majorName) {
		return majorDao.loadByHql("from Major where majorName=?",majorName);
	}

	@Override
	public boolean checkMajor(String majorName) {
		long count = (Long)majorDao.loadObjByHQL("select count(*) from Major where majorName=?",majorName);
		return count>0?true:false;
	}

	@Override
	public void addMajorFromInputStream(InputStream inputStream)
			throws IOException {

	}

}
