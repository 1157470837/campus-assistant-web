package com.techthinker.CAWeb.dao;


import org.springframework.stereotype.Repository;

import com.techthinker.CAWeb.idao.ITempIndexDao;
import com.techthinker.CAWeb.persistence.TempIndex;

@Repository("tempIndexDao")
public class TempIndexDao extends BaseDao<TempIndex> implements ITempIndexDao {

	@Override
	public void delAll() {
		this.getSession().createSQLQuery("truncate table tempindex").executeUpdate();
	}


}
