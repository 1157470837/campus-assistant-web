package com.techthinker.CAWeb.dao;

import org.springframework.stereotype.Repository;

import com.techthinker.CAWeb.idao.IUserDao;
import com.techthinker.CAWeb.vo.User;

@Repository("useDao")
public class UseDao extends BaseDao<User> implements IUserDao {

}
