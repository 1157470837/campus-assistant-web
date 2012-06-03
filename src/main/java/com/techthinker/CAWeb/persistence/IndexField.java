package com.techthinker.CAWeb.persistence;

import org.apache.solr.client.solrj.beans.Field;

/**
 * 要添加的索引域对象,目的是将相应的对象转换为IndexField之后传输到IIndexService进行更新操作
 * 最终添加到solr服务器进行索引
 * @author JC@Techthinker.com
 *
 */
public class IndexField {

	private String id;
	private int subjectId;
	private String title;
	private String content;
	private String action;
	
	/**
	 * 索引的唯一标识
	 * @return
	 */
	public String getId() {
		return id;
	}
	
	@Field
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * 被索引对象的id
	 * @return the subjectId
	 */
	public int getSubjectId() {
		return subjectId;
	}

	/**
	 * @param subjectId the subjectId to set
	 */
	@Field("index_subjectid")
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	/**
	 * 被索引对象的主题
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	
	@Field("index_title")
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * 被索引对象的详细内容
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	@Field("index_content")
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * 被索引对象对应的Action
	 * @param action the action to set
	 */
	@Field("index_action")
	public void setAction(String action) {
		this.action = action;
	}
	
	@Override
	public String toString() {
		return "IndexField [id=" + id + ", subjectId=" + subjectId + ", title="
				+ title + ", content=" + content + ", action=" + action + "]";
	}
}
