package com.techthinker.CAWeb.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techthinker.CAWeb.exception.MajorException;
import com.techthinker.CAWeb.idao.ICollegeDao;
import com.techthinker.CAWeb.idao.IMajorDao;
import com.techthinker.CAWeb.iservice.IMajorService;
import com.techthinker.CAWeb.util.PageObject;
import com.techthinker.CAWeb.vo.College;
import com.techthinker.CAWeb.vo.Major;

@Service("majorService")
public class MajorService implements IMajorService {

	private IMajorDao majorDao;
	private ICollegeDao collegeDao;
	
	public ICollegeDao getCollegeDao() {
		return collegeDao;
	}

	@Resource
	public void setCollegeDao(ICollegeDao collegeDao) {
		this.collegeDao = collegeDao;
	}

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
		BufferedReader br = new BufferedReader(new InputStreamReader(
				inputStream));
		String r = br.readLine();
		College c = new College();
		r = br.readLine();
		while( r!=null && r.contains("----------")){
			//"------------"表示一个学院的开始标识
			String []titles = br.readLine().split(",");
			c = collegeDao.loadByHql("from College where collegeName=? ",titles[0]);
			r = br.readLine();
			int n = Integer.parseInt(titles[1]);
			for(int i=0; i<n; i++){
				//读取一个专业的信息
				Major m = new Major();
				m.setCollege(c);
				m.setMajorName(r);
				m.setDescription(br.readLine().trim());
				m.setImage(null);
				majorDao.add(m);
				r = br.readLine();
			}
			
		}

	}

}
