package com.techthinker.CAWeb.dao;

import org.springframework.stereotype.Repository;

import com.techthinker.CAWeb.idao.IScenicspotDao;
import com.techthinker.CAWeb.persistence.Scenicspot;

@Repository("scenicspotDao")
public class ScenicspotDao extends BaseDao<Scenicspot> implements IScenicspotDao {

}
