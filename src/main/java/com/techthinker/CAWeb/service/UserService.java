package com.techthinker.CAWeb.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techthinker.CAWeb.exception.UserException;
import com.techthinker.CAWeb.idao.IMajorDao;
import com.techthinker.CAWeb.idao.IScenicspotDao;
import com.techthinker.CAWeb.idao.IUserDao;
import com.techthinker.CAWeb.idao.IUsertypeDao;
import com.techthinker.CAWeb.iservice.IUserService;
import com.techthinker.CAWeb.util.PageObject;
import com.techthinker.CAWeb.vo.Major;
import com.techthinker.CAWeb.vo.Scenicspot;
import com.techthinker.CAWeb.vo.User;
import com.techthinker.CAWeb.vo.Usertype;

@Service("userService")
public class UserService implements IUserService {

	private IUserDao userDao;
	private IMajorDao majorDao;
	private IScenicspotDao scenicspotDao;
	private IUsertypeDao usertypeDao;

	public IUsertypeDao getUsertypeDao() {
		return usertypeDao;
	}

	@Resource
	public void setUsertypeDao(IUsertypeDao usertypeDao) {
		this.usertypeDao = usertypeDao;
	}

	public IScenicspotDao getScenicspotDao() {
		return scenicspotDao;
	}

	@Resource
	public void setScenicspotDao(IScenicspotDao scenicspotDao) {
		this.scenicspotDao = scenicspotDao;
	}

	public IMajorDao getMajorDao() {
		return majorDao;
	}

	@Resource
	public void setMajorDao(IMajorDao majorDao) {
		this.majorDao = majorDao;
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	@Resource
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add(User u) {
		User tu = loadByUsername(u.getUsername());
		if(tu!=null) throw new UserException("要添加的用户已经存在，不能添加");
		userDao.add(u);

	}

	@Override
	public void update(User u) {
		this.userDao.update(u);

	}

	@Override
	public void delete(int id) {
		this.userDao.delete(id);

	}

	@Override
	public User load(int id) {
		return this.load(id);
	}

	@Override
	public List<User> list() {
		return this.userDao.list("from User");
	}

	@Override
	public User login(String username, String pwd) {
		User u = loadByUsername(username);
		if(u==null) throw new UserException("用户不存在！");
		if(!u.getPassword().equals(pwd)) throw new UserException("用户密码不正确！");
		return u;
	}

	@Override
	public PageObject<User> find(String userName) {
		if(userName==null||"".equals(userName.trim())) {
			return userDao.find("from User");
		} else {
			return userDao.find("from User where username like ?",
					new Object[]{"%"+userName+"%"});
		}
	}

	@Override
	public User loadByUsername(String userName) {
		return userDao.loadByHql("from User where username=?",userName);
	}

	@Override
	public boolean checkUser(String userName) {
		long count = (Long)userDao.loadObjByHQL("select count(*) from User where username=?",userName);
		return count>0?true:false;
	}

	@Override
	public void addUserFromInputStream(InputStream inputStream)
			throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				inputStream));
		String r = br.readLine();
		
		Major m = null;
		String majorName;
		User tempUser = null;
		Usertype tUsertype = null;
		
		r = br.readLine();
		while( r!=null){
			if(r.contains("----------")){//"------------"表示一个用户的开始标识	
				majorName = br.readLine();
				m = majorDao.loadByHql("from Major where majorName=? ",majorName);
				
			}else{	
				tempUser = new User();
				String [] infos = r.split(",");

				tempUser.setUsername(infos[0].trim());
				tempUser.setPassword(infos[2].trim());
				tempUser.setSex(infos[1].trim());
				tempUser.setEmail(infos[3]);
				tUsertype = new Usertype();
				tUsertype = usertypeDao.loadByHql("from Usertype where usertypeNum=?",Integer.parseInt(infos[4].trim()));
				tempUser.setUsertype(tUsertype);
				tempUser.setEntranceYear(Integer.parseInt(infos[5]));
				tempUser.setBirthday(Timestamp.valueOf(infos[6]+" 00:00:00"));
				tempUser.setPhone(infos[7]);
				tempUser.setDescription(infos[8]);
				tempUser.setMajor(m);
				tempUser.setCollege(m.getCollege());
				Scenicspot tempS = scenicspotDao.loadByHql("from Scenicspot where spotname = ?",infos[9]);
				tempUser.setGeoinfo(tempS.getGeoinfo());
				
				userDao.add(tempUser);
				
			}
			
			r = br.readLine();
			
		}
		
	}

}
