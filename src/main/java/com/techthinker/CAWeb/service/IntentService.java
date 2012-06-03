package com.techthinker.CAWeb.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techthinker.CAWeb.idao.IIntentDao;
import com.techthinker.CAWeb.idao.ITempIndexDao;
import com.techthinker.CAWeb.iservice.IIntentService;
import com.techthinker.CAWeb.persistence.Intent;
import com.techthinker.CAWeb.persistence.TempIndex;
import com.techthinker.CAWeb.util.IndexUtil;

@Service("intentService")
public class IntentService implements IIntentService {
	private IIntentDao intentDao;
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
	 * @return the intentdao
	 */
	public IIntentDao getIntentdao() {
		return intentDao;
	}


	/**
	 * @param intentdao the intentdao to set
	 */
	@Resource
	public void setIntentdao(IIntentDao intentdao) {
		this.intentDao = intentdao;
	}


	@Override
	public void addIntentsFromInputStream(InputStream inputStream)
			throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				inputStream));
		String r = br.readLine();
		Intent intent=null;
		while( r!=null){
			if(r.contains("----------")){//"------------"表示一个用户的开始标识	
			}else{
				intent = new Intent();
				intent.setBrief(r);
				intent.setExtension(br.readLine());
				intent.setIntention(br.readLine());
				intent.setAvailabe(Boolean.valueOf(br.readLine()));
				intentDao.add(intent);
				
				TempIndex tempIndex = new TempIndex();
				tempIndex.setAdd();
				tempIndex.setObjId(intent.getIntent_id());
				tempIndex.setObjType(IndexUtil.ACTION_INTENT);
				tempIndexDao.add(tempIndex);
			}
			r = br.readLine();
		}
	}
}