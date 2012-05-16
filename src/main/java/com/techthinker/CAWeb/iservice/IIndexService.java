package com.techthinker.CAWeb.iservice;


import com.techthinker.CAWeb.util.PageObject;
import com.techthinker.CAWeb.vo.Index;
import com.techthinker.CAWeb.vo.IndexField;

public interface IIndexService {
	public void addIndex(IndexField fields,boolean inDatabase);
	public void deleteIndex(String id,String type);
	public void updateIndex(IndexField fields);
	
	public PageObject<Index> findByIndex(String condition);
	/**
	 * 提交索引,仅仅是从内存中提交
	 */
	public void updateCommitIndex();
	/**
	 * 重构索引
	 */
	public void updateReconstructorIndex();
	/**
	 * 设置索引，将数据库中没有添加为索引的对象完全添加
	 */
	public void updateSetIndex(); 
}
