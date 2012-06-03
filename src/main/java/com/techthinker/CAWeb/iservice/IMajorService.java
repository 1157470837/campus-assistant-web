package com.techthinker.CAWeb.iservice;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.techthinker.CAWeb.persistence.Major;
import com.techthinker.CAWeb.util.PageObject;

public interface IMajorService {
	/**
	 * 添加专业
	 * 判断专业名是否唯一，如果不唯一抛出异常
	 * @param major 要添加的专业
	 */
	public void add(Major major);
	/**
	 * 更新专业
	 * 不能更新专业名
	 * @param major 要更新的专业
	 */
	public void update(Major major);
	/**
	 * 删除专业
	 * @param id
	 */
	public void delete(int id);
	/**
	 * 根据专业id来获取相应的专业
	 * @param id 需要获取专业的主键id
	 * @return 需要获取的专业
	 */
	public Major load(int id);
	/**
	 * 获取所有专业列表
	 * @return 所有专业列表
	 */
	public List<Major> list();
	/**
	 * 根据分页获取专业信息
	 * @param pageOffset 从哪一个位置开始查询
	 * @param pageSize 每页显示多少条
	 * @return
	 */
	public PageObject<Major> find(String majorName);
	/**
	 * 根据专业名获取某个专业
	 * @param majorName
	 * @return
	 */
	public Major loadByMajorname(String majorName);
	/**
	 * 根据学院Id列出所有属于这个学院的专业
	 * @param id 学院id号
	 * @return List<Major>
	 */
	public List<Major> listMajorsByCollegeId(int id);
	/**
	 * 检查专业是否存在
	 * @param majorName
	 * @return
	 */
	public boolean checkMajor(String majorName);
	/**
	 * 从输入流里读取专业信息，批量读取
	 * @param inputStream
	 * @throws IOException
	 */
	public void addMajorFromInputStream(InputStream inputStream)
			throws IOException;
}
