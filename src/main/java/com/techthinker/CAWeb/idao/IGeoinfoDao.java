package com.techthinker.CAWeb.idao;

import java.util.List;

import com.techthinker.CAWeb.vo.Geoinfo;

public interface IGeoinfoDao extends IBaseDao<Geoinfo> {
	public void addGeoinfoList(List<Geoinfo> geoinfos);
}
