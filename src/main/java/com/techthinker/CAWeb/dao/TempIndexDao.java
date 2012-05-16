package com.techthinker.CAWeb.dao;


import org.springframework.stereotype.Repository;

import com.techthinker.CAWeb.idao.ITempIndexDao;
import com.techthinker.CAWeb.vo.TempIndex;

@Repository("tempIndexDao")
public class TempIndexDao extends BaseDao<TempIndex> implements ITempIndexDao {

	@Override
	public void delAll() {
		// TODO Auto-generated method stub
		
	}
}
