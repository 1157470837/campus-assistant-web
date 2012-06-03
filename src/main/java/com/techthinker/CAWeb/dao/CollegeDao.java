package com.techthinker.CAWeb.dao;


import org.springframework.stereotype.Repository;

import com.techthinker.CAWeb.idao.ICollegeDao;
import com.techthinker.CAWeb.persistence.College;

@Repository("collegeDao")
public class CollegeDao extends BaseDao<College> implements ICollegeDao {

}
