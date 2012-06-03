package com.techthinker.CAWeb.dao;

import org.springframework.stereotype.Repository;

import com.techthinker.CAWeb.idao.IRelationDao;
import com.techthinker.CAWeb.persistence.Relation;

@Repository("relationDao")
public class RelationDao extends BaseDao<Relation> implements IRelationDao {

}
