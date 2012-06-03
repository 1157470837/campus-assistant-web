package com.techthinker.CAWeb.dao;


import org.springframework.stereotype.Repository;

import com.techthinker.CAWeb.idao.ICampusnewsDao;
import com.techthinker.CAWeb.persistence.Campusnews;

@Repository("campusnewsDao")
public class CampusnewsDao extends BaseDao<Campusnews> implements
		ICampusnewsDao {


}
