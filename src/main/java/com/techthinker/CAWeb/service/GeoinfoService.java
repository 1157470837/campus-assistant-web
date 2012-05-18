package com.techthinker.CAWeb.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techthinker.CAWeb.dao.GeoinfoDao;
import com.techthinker.CAWeb.iservice.IGeoinfoService;
import com.techthinker.CAWeb.vo.Geoinfo;

@Service("geoinfoService")
public class GeoinfoService implements IGeoinfoService {
	private GeoinfoDao geoinfoDao;
	/**
	 * @return the geoinfoDao
	 */
	public GeoinfoDao getGeoinfoDao() {
		return geoinfoDao;
	}

	/**
	 * @param geoinfoDao the geoinfoDao to set
	 */
	@Resource
	public void setGeoinfoDao(GeoinfoDao geoinfoDao) {
		this.geoinfoDao = geoinfoDao;
	}
	
	@Override
	public void addGeoinfosFromInputStream(InputStream inputStream)
			throws IOException {
		double[] longtitude = new double[4];
		double[] latitude = new double[4];
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		br.readLine();
		String r = br.readLine();
		List<Geoinfo> geoinfos = new ArrayList<Geoinfo>();
		while (r != null) {
			for (int i = 0; i < 4; i++) {
				r = br.readLine();
				String[] local = r.split(",");
				latitude[i] = Double.valueOf(local[0]);
				longtitude[i] = Double.valueOf(local[1]);
			}
			
			Geoinfo geoinfo = new Geoinfo();
			geoinfo.setLatitude1(latitude[0]);
			geoinfo.setLatitude2(latitude[1]);
			geoinfo.setLatitude3(latitude[2]);
			geoinfo.setLatitude4(latitude[3]);
			geoinfo.setLongtitude1(longtitude[0]);
			geoinfo.setLongtitude2(longtitude[1]);
			geoinfo.setLongtitude3(longtitude[2]);
			geoinfo.setLongtitude4(longtitude[3]);
			geoinfo.setAvailabe(true);
			geoinfos.add(geoinfo);
			
			r = br.readLine();
		}
		geoinfoDao.addGeoinfoList(geoinfos);
	}

}
