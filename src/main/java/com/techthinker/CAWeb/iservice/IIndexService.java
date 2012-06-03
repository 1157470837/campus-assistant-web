package com.techthinker.CAWeb.iservice;

import java.util.List;

import com.techthinker.CAWeb.persistence.IndexField;

public interface IIndexService {
	/**
	 * 向solr服务器中添加一个索引域
	 * @param fields 要添加的索引域
	 */
	public void addIndex(IndexField field);
	/**
	 * 向solr服务器中添加一个索引域
	 * @param fields 要添加的索引域
	 */
	public void addIndex(List<IndexField> fields);
	/**
	 * 根据id删除solr服务器中的索引
	 * @param id 要删除索引的id
	 */
	public void deleteIndex(String id);
	/**
	 * 向solr服务器中更新一条索引
	 * @param fields
	 */
	public void updateIndex(IndexField field);
	/**
	 * 设置索引，将数据库中没有添加为索引的对象完全添加
	 */
	public void updateSetIndex(); 
	/**
	 * 重构索引,遍历整个数据库提出需索引的内容,并提交到solr
	 */
	public void updateReconstructorIndex();
	
}
