package com.techthinker.CAWeb.iservice;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import com.techthinker.CAWeb.util.PageObject;
import com.techthinker.CAWeb.vo.Campusnews;

public interface ICampusnewsService {
	/**
	 * 添加校园消息
	 * 判断校园消息名是否唯一，如果不唯一抛出异常
	 * @param Campusnews 要添加的校园消息
	 */
	public void add(Campusnews campusnews);
	/**
	 * 更新校园消息
	 * 不能更新校园消息名
	 * @param Campusnews 要更新的校园消息
	 */
	public void update(Campusnews campusnews);
	/**
	 * 删除校园消息
	 * @param id
	 */
	public void delete(int id);
	/**
	 * 根据校园消息id来获取相应的校园消息
	 * @param id 需要获取校园消息的主键id
	 * @return 需要获取的校园消息
	 */
	public Campusnews load(int id);
	/**
	 * 获取所有校园消息列表
	 * @return 所有校园消息列表
	 */
	public List<Campusnews> list();

	/**
	 * 根据分页获取校园消息信息
	 * @param pageOffset 从哪一个位置开始查询
	 * @param pageSize 每页显示多少条
	 * @return
	 */
	public PageObject<Campusnews> find(int newstype,
										Date pubdate,
										int userId,
										int collegeId,
										int majorId,
										int level);
	/**
	 * 从输入流里读取校园消息信息，批量读取
	 * @param inputStream
	 * @throws IOException
	 */
	public void addCampusnewsFromInputStream(InputStream inputStream)
			throws IOException;
}
