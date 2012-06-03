package com.techthinker.CAWeb.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techthinker.CAWeb.idao.IUsertypeDao;
import com.techthinker.CAWeb.iservice.IUsertypeService;
import com.techthinker.CAWeb.persistence.Usertype;

@Service("usertypeService")
public class UsertypeService implements IUsertypeService {
	private IUsertypeDao usertypeDao;

	/**
	 * @return the usertypeDao
	 */
	public IUsertypeDao getUsertypeDao() {
		return usertypeDao;
	}

	/**
	 * @param usertypeDao
	 *            the usertypeDao to set
	 */
	@Resource
	public void setUsertypeDao(IUsertypeDao usertypeDao) {
		this.usertypeDao = usertypeDao;
	}

	
	
	@Override
	public Usertype loadByUsertypeId(int id) {
		return usertypeDao.load(id);
	}

	@Override
	public void addUsertypeFromInputStream(InputStream inputStream)
			throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				inputStream));
		String r = br.readLine();
		Usertype tUsertype = null;

		r = br.readLine();
		while (r != null) {
			if (r.contains("----------")) {// "------------"表示一个用户的开始标识
			} else {
				tUsertype = new Usertype();
				String[] infos = r.split(",");
				tUsertype.setUsertypeName(infos[0].trim());
				tUsertype.setUsertypeNum(Integer.valueOf(infos[1].trim()));
				usertypeDao.add(tUsertype);
			}
			r = br.readLine();
		}
	}
	
	
}
