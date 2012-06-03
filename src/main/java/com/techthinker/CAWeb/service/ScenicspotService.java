package com.techthinker.CAWeb.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Blob;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import com.techthinker.CAWeb.idao.IScenicspotDao;
import com.techthinker.CAWeb.idao.ITempIndexDao;
import com.techthinker.CAWeb.iservice.IGeoinfoService;
import com.techthinker.CAWeb.iservice.IScenicspotService;
import com.techthinker.CAWeb.persistence.Geoinfo;
import com.techthinker.CAWeb.persistence.Scenicspot;
import com.techthinker.CAWeb.persistence.TempIndex;
import com.techthinker.CAWeb.util.IndexUtil;
import com.techthinker.CAWeb.util.SystemConstant;

@Service("scenicspotService")
public class ScenicspotService implements IScenicspotService {
	private IGeoinfoService geoinfoService;
	private IScenicspotDao scenicspotDao;
	private ITempIndexDao tempIndexDao;
	

	/**
	 * @return the tempIndexDao
	 */
	public ITempIndexDao getTempIndexDao() {
		return tempIndexDao;
	}

	/**
	 * @param tempIndexDao the tempIndexDao to set
	 */
	@Resource
	public void setTempIndexDao(ITempIndexDao tempIndexDao) {
		this.tempIndexDao = tempIndexDao;
	}

	/**
	 * @return the geoinfoService
	 */
	public IGeoinfoService getGeoinfoService() {
		return geoinfoService;
	}

	/**
	 * @param geoinfoService
	 *            the geoinfoService to set
	 */
	@Resource
	public void setGeoinfoService(IGeoinfoService geoinfoService) {
		this.geoinfoService = geoinfoService;
	}

	/**
	 * @return the scenicspotDao
	 */
	public IScenicspotDao getScenicspotDao() {
		return scenicspotDao;
	}

	/**
	 * @param scenicspotDao
	 *            the scenicspotDao to set
	 */
	@Resource
	public void setScenicspotDao(IScenicspotDao scenicspotDao) {
		this.scenicspotDao = scenicspotDao;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void addScenicspotsFromInputStream(InputStream inputStream)
			throws IOException {
		Double[] longtitude = new Double[4];
		Double[] latitude = new Double[4];
		BufferedReader br = new BufferedReader(new InputStreamReader(
				inputStream));
		String r = br.readLine();
		r = br.readLine();
		while (r != null) {
			Scenicspot scenicspot = new Scenicspot();
			scenicspot.setSpotname(r);
			scenicspot.setDescription(br.readLine().trim());
			String imageName = br.readLine().trim();
			try {
				InputStream input = this
						.getClass()
						.getClassLoader()
						.getResourceAsStream(
								SystemConstant.SCENICSPOT_IMAGE_FOULDER + "/"
										+ imageName);
				Blob image = Hibernate.createBlob(input);
				scenicspot.setImage(image);
			} catch (Exception e) {
			}
			scenicspot.setRateMean(0.0);
			scenicspot.setRateNum(0);
			for (int i = 0; i < 4; i++) {
				r = br.readLine();
				String[] local = r.split(",");
				latitude[i] = Double.valueOf(local[0]);
				longtitude[i] = Double.valueOf(local[1]);
			}
			r = br.readLine();
			if (r != null && r.contains("----------"))
				r = br.readLine();
			Geoinfo geoinfo = geoinfoService.addGeoinfoByLocation(longtitude,
					latitude, true);
			scenicspot.setGeoinfo(geoinfo);
			scenicspotDao.add(scenicspot);
			TempIndex tempIndex = new TempIndex();
			tempIndex.setAdd();
			tempIndex.setObjId(scenicspot.getScenicspotId());
			tempIndex.setObjType(IndexUtil.ACTION_SCENICSPOT);
			tempIndexDao.add(tempIndex);
		}

	}

	@Override
	public Scenicspot checkScenicspotsIdExists(int scenicspotId) {
		Scenicspot scenicspot = scenicspotDao.load(scenicspotId);
		if(scenicspot!=null)return scenicspot;
		else return null;
	}

	@Override
	public List<Scenicspot> listDormitories() {
		return scenicspotDao.list("from Scenicspot s where s.spotname like \'%G%\'");
	}

	@Override
	public Scenicspot loadDormByName(String name) {
		return scenicspotDao.loadByHql("from Scenicspot s where s.spotname = ?",name);
	}

	@Override
	public Scenicspot load(int id) {
		return scenicspotDao.load(id);
	}
	
	
}
