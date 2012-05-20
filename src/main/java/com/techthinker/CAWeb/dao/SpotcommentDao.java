package com.techthinker.CAWeb.dao;

import org.springframework.stereotype.Repository;

import com.techthinker.CAWeb.idao.ISpotcommentDao;
import com.techthinker.CAWeb.vo.Spotcomment;

@Repository("spotcommentDao")
public class SpotcommentDao extends BaseDao<Spotcomment> implements
		ISpotcommentDao {

}
