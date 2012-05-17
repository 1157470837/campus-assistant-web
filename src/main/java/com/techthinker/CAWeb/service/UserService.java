package com.techthinker.CAWeb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techthinker.CAWeb.iservice.IUserService;
import com.techthinker.CAWeb.util.PageObject;
import com.techthinker.CAWeb.vo.User;

@Service("userService")
public class UserService implements IUserService {

	@Override
	public void add(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User load(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User login(String username, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageObject<User> find(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User loadByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkUser(String username) {
		// TODO Auto-generated method stub
		return false;
	}
//	private IUserDao userDao;
//
//	public IUserDao getUserDao() {
//		return userDao;
//	}
//	@Resource
//	public void setUserDao(IUserDao userDao) {
//		this.userDao = userDao;
//	}
//
//	public void add(User u) {
//		User tu = loadByUsername(u.getUsername());
//		if(tu!=null) throw new CampusNewsException("要添加的用户已经存在，不能添加");
//		u.setCreateDate(new Date());
//		userDao.add(u);
//	}
//
//	public void update(User u) {
//		userDao.update(u);
//	}
//
//	public void delete(int id) {
//		userDao.delete(id);
//	}
//
//	public User load(int id) {
//		return userDao.load(id);
//	}
//
//	public List<User> list() {
//		return userDao.list("from User");
//	}
//
//	public User login(String username, String pwd) {
//		User u = loadByUsername(username);
//		if(u==null) throw new CampusNewsException("用户不存在！");
//		if(!u.getPassword().equals(pwd)) throw new CampusNewsException("用户密码不正确！");
//		if(u.getStatus()==1) throw new CampusNewsException("该用户已经被停用，请与管理员联系");
//		return u;
//	}
//
//	public PageObject<User> find(String name) {
//		if(name==null||"".equals(name.trim())) {
//			return userDao.find("from User");
//		} else {
//			return userDao.find("from User where nickname like ? or username like ?",
//					new Object[]{"%"+name+"%","%"+name+"%"});
//		}
//	}
//
//	public User loadByUsername(String username) {
//		return userDao.loadByHql("from User where username=?",username);
//	}
//	public boolean checkUser(String username) {
//		long count = (Long)userDao.loadObjByHQL("select count(*) from User where username=?",username);
//		return count>0?true:false;
//	}

}
