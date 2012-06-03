package com.techthinker.CAWeb.iservice;

import java.util.List;

import com.techthinker.CAWeb.persistence.Relation;
import com.techthinker.CAWeb.util.PageObject;

public interface IRelationService {
	/**
	 * 添加朋友
	 * 判断朋友名是否唯一，如果不唯一抛出异常
	 * @param Relation 要添加的朋友
	 */
	public void add(Relation relation);
	/**
	 * 根据ID删除朋友
	 * @param id
	 */
	public void delete(int id);
	/**
	 * 根据朋友id来获取相应的朋友
	 * @param id 需要获取朋友的主键id
	 * @return 需要获取的朋友
	 */
	public Relation load(int id);
	/**
	 * 获取所有朋友列表
	 * @return 所有朋友列表
	 */
	public List<Relation> list();
	/**
	 * 根据分页获取朋友信息
	 * @param pageOffset 从哪一个位置开始查询
	 * @param pageSize 每页显示多少条
	 * @return
	 */
	public PageObject<Relation> find(int userId);
}
