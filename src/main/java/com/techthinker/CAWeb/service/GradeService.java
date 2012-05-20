package com.techthinker.CAWeb.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techthinker.CAWeb.exception.GradeException;
import com.techthinker.CAWeb.idao.IGradeDao;
import com.techthinker.CAWeb.iservice.IGradeService;
import com.techthinker.CAWeb.util.PageObject;
import com.techthinker.CAWeb.vo.Grade;

@Service("gradeService")
public class GradeService implements IGradeService {

	private IGradeDao gradeDao;
	
	public IGradeDao getGradeDao() {
		return gradeDao;
	}

	@Resource
	public void setGradeDao(IGradeDao gradeDao) {
		this.gradeDao = gradeDao;
	}

	@Override
	public void add(Grade grade) {
		Grade tg = this.loadByGradename(grade.getGradeName());
		if(tg != null) throw new GradeException("要添加的班级已经存在，不能添加");
		this.gradeDao.add(grade);

	}

	@Override
	public void update(Grade grade) {
		this.gradeDao.update(grade);

	}

	@Override
	public void delete(int id) {
		this.gradeDao.delete(id);

	}

	@Override
	public Grade load(int id) {
		return this.gradeDao.load(id);
	}

	@Override
	public List<Grade> list() {
		return this.gradeDao.list("from Grade");
	}

	@Override
	public PageObject<Grade> find(String gradeName) {
		if(gradeName==null||"".equals(gradeName.trim())) {
			return gradeDao.find("from Grade");
		} else {
			return gradeDao.find("from Grade where gradeName like ?",
					new Object[]{"%"+gradeName+"%"});
		}
	}

	@Override
	public Grade loadByGradename(String gradeName) {
		return this.gradeDao.loadByHql("from Grade where gradeNaem = ?", gradeName);
	}

	@Override
	public boolean checkGrade(String gradeName) {
		long count = (Long)gradeDao.loadObjByHQL("select count(*) from User where gradeName=?",gradeName);
		return count>0?true:false;
	}

}
