package com.techthinker.CAWeb.iservice;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.techthinker.CAWeb.util.PageObject;
import com.techthinker.CAWeb.vo.College;

public interface ICollegeService {
	/**
	 * 添加学院
	 * 判断学院名是否唯一，如果不唯一抛出异常
	 * @param College 要添加的学院
	 */
	public void add(College college);
	/**
	 * 更新学院
	 * 不能更新学院名
	 * @param College 要更新的学院
	 */
	public void update(College college);
	/**
	 * 删除学院
	 * @param id
	 */
	public void delete(int id);
	/**
	 * 根据学院id来获取相应的学院
	 * @param id 需要获取学院的主键id
	 * @return 需要获取的学院
	 */
	public College load(int id);
	/**
	 * 获取所有学院列表
	 * @return 所有学院列表
	 */
	public List<College> list();
	/**
	 * 根据分页获取学院信息
	 * @param pageOffset 从哪一个位置开始查询
	 * @param pageSize 每页显示多少条
	 * @return
	 */
	public PageObject<College> find(String collegeName);
	/**
	 * 根据学院名获取某个学院
	 * @param collegeName
	 * @return
	 */
	public College loadByCollegename(String collegeName);
	/**
	 * 检查学院是否存在
	 * @param collegeName
	 * @return
	 */
	public boolean checkCollege(String collegeName);
	/**
	 * 从输入流里读取学院信息，批量读取
	 * @param inputStream
	 * @throws IOException
	 */
	public void addCollegeFromInputStream(InputStream inputStream)
			throws IOException;
}
