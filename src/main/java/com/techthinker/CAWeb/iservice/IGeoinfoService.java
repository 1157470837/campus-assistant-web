package com.techthinker.CAWeb.iservice;

import java.io.IOException;
import java.io.InputStream;

import com.techthinker.CAWeb.vo.Geoinfo;

public interface IGeoinfoService {
	
	/**
	 * 从输入流中批量读取geoinfo，并插入数据库
	 * @param inputStream 输入流
	 * @throws IOException IO异常
	 */
	public void addGeoinfosFromInputStream(InputStream inputStream)
			throws IOException;

	/**
	 * 根据经纬度添加geoinfo对象，并插入到数据库
	 * @param longtitude
	 * @param latitude
	 * @param available
	 */
	public Geoinfo addGeoinfoByLocation(Double[] longtitude,Double[] latitude,boolean available);
}
