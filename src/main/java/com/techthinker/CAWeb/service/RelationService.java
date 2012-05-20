package com.techthinker.CAWeb.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techthinker.CAWeb.idao.IRelationDao;
import com.techthinker.CAWeb.iservice.IRelationService;
import com.techthinker.CAWeb.util.PageObject;
import com.techthinker.CAWeb.vo.Relation;

@Service("relationService")
public class RelationService implements IRelationService {

	private IRelationDao relationDao;
	public IRelationDao getRelationDao() {
		return relationDao;
	}

	@Resource
	public void setRelationDao(IRelationDao relationDao) {
		this.relationDao = relationDao;
	}

	@Override
	public void add(Relation relation) {
		Relation tr = this.relationDao.load(relation.getRelationId());
		if (tr == null)	this.relationDao.add(relation);
	}

	@Override
	public void delete(int id) {
		this.relationDao.delete(id);
		
	}

	@Override
	public Relation load(int id) {
		return this.relationDao.load(id);
	}

	@Override
	public List<Relation> list() {
		return this.relationDao.list("from Relation");
	}

	@Override
	public PageObject<Relation> find(int userId) {
		if(userId == 0) {
			return relationDao.find("from User");
		} else {
			return relationDao.find("from User where userId like ?",
					new Object[]{"%"+userId+"%"});
		}
	}	

}
