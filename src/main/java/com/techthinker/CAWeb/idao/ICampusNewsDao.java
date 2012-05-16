package com.techthinker.CAWeb.idao;

import java.util.List;
import java.util.Map;

import com.techthinker.CAWeb.vo.CampusNews;


public interface ICampusNewsDao extends IBaseDao<CampusNews>{
	public List<CampusNews> listByUser(int id);
	
	public Map<Integer,String> listMessageContent(List<Integer> ids);
}
