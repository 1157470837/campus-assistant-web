package com.techthinker.CAWeb.dao;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.techthinker.CAWeb.idao.ICampusNewsDao;
import com.techthinker.CAWeb.vo.CampusNews;

@Repository("messageDao")
public class CampusNewsDao extends BaseDao<CampusNews> implements ICampusNewsDao {

	@Override
	public List<CampusNews> listByUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, String> listMessageContent(List<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}



}
