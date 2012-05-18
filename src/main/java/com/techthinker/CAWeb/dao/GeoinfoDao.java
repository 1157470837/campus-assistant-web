package com.techthinker.CAWeb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.techthinker.CAWeb.idao.IGeoinfoDao;
import com.techthinker.CAWeb.vo.Geoinfo;


@Repository("geoinfoDao")
public class GeoinfoDao extends BaseDao<Geoinfo> implements IGeoinfoDao {

	@Override
	public void addGeoinfoList(List<Geoinfo> geoinfos) {
		for (Geoinfo g : geoinfos) {
			this.add(g);
		}
	}

}
