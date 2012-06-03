
package com.techthinker.CAWeb.iservice;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.techthinker.CAWeb.persistence.Grade;
import com.techthinker.CAWeb.util.PageObject;

public interface IGradeService {

	/**
	 * 添加班级
	 * 判断班级名是否唯一，如果不唯一抛出异常
	 * @param grade 要添加的班级
	 */
	public void add(Grade grade);
	/**
	 * 更新班级
	 * 判断班级名是否唯一，如果不唯一抛出异常
	 * @param grade 要更新的班级
	 */
	public void update(Grade grade);
	/**
	 * 删除班级
	 * 删除班级首先需要删除聊天室里依赖此班级的记录和用户表中（根据入学时间）依赖此表的记录
	 * @param id
	 */
	public void delete(int id);
	/**
	 * 根据班级id来获取相应的班级
	 * @param id 需要获取班级的主键id
	 * @return 需要获取的班级
	 */
	public Grade load(int id);
	/**
	 * 获取所有班级列表
	 * @return 所有班级列表
	 */
	public List<Grade> list();
	/**
	 * 根据分页获取班级信息
	 * @param pageOffset 从哪一个位置开始查询
	 * @param pageSize 每页显示多少条
	 * @return
	 */
	public PageObject<Grade> find(String gradeName);
	/**
	 * 根据班级名获取某个班级
	 * @param gradeName
	 * @return
	 */
	public Grade loadByGradename(String gradeName);
	/**
	 * 检查班级是否存在
	 * @param Gradename
	 * @return
	 */
	public boolean checkGrade(String gradeName);
	/**
	 * 从输入流里读取专业信息，批量读取
	 * @param inputStream
	 * @throws IOException
	 */
	public void addGradeFromInputStream(InputStream inputStream)
			throws IOException;

}
