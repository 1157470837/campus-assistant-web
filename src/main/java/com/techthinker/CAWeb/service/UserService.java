package com.techthinker.CAWeb.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techthinker.CAWeb.exception.UserException;
import com.techthinker.CAWeb.idao.IUserDao;
import com.techthinker.CAWeb.iservice.IUserService;
import com.techthinker.CAWeb.util.PageObject;
import com.techthinker.CAWeb.vo.User;

@Service("userService")
public class UserService implements IUserService {

	private IUserDao userDao;
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

}
