package com.techthinker.CAWeb.dao;

import org.springframework.stereotype.Repository;

import com.techthinker.CAWeb.idao.IIntentDao;
import com.techthinker.CAWeb.persistence.Intent;

@Repository("intentDao")
public class IntentDao extends BaseDao<Intent> implements IIntentDao {

}
