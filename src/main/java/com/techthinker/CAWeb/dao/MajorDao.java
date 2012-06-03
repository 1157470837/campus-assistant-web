package com.techthinker.CAWeb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.techthinker.CAWeb.idao.IMajorDao;
import com.techthinker.CAWeb.persistence.Major;

@Repository("majorDao")
public class MajorDao extends BaseDao<Major> implements IMajorDao {

	@Override
	public void addMajorList(List<Major> majors) {
		for (Major m : majors) {
			this.add(m);
		}
		
	}

}
