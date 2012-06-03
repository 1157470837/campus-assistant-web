package com.techthinker.CAWeb.iservice;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import com.techthinker.CAWeb.persistence.Campusnews;
import com.techthinker.CAWeb.persistence.College;
import com.techthinker.CAWeb.persistence.Major;
import com.techthinker.CAWeb.util.PageObject;

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
	 * 获取所有校园消息列表(包括新闻和通知)
	 * @return 所有校园消息列表
	 */
	public List<Campusnews> list();
	/**
	 * 获取所有校园新闻列表
	 * @return
	 */
	public List<Campusnews> listNews();
	/**
	 * 获取所有学院通过信息
	 * @return
	 */
	public List<Campusnews> listCollegeNotif();
	/**
	 * 获取所有专业通过信息
	 * @return
	 */
	public List<Campusnews> listMajorNotif();
	/**
	 * 获取所有通过信息(包括学校、学院和专业)
	 * @return
	 */
	public List<Campusnews> listNotif();
	/**
	 * 获取所有学校通过信息
	 * @return
	 */
	public List<Campusnews> listCampusNotif();

	/**
	 * 获取校园消息信息,并用分页显示
	 * @param pageOffset 从哪一个位置开始查询
	 * @param pageSize 每页显示多少条
	 * @param type	类型:1.新闻,2.通知,0.新闻和通知
	 * @return
	 */
	public PageObject<Campusnews> find(int type);
	/**
	 * 根据日期获取校园消息信息,并用分页显示
	 * @param start 开始日期
	 * @param End	结束日期
	 * @param type	类型:1.新闻,2.通知,0.新闻和通知
	 * @return
	 */
	public PageObject<Campusnews> findByDate(Date start,Date End,int type);
	/**
	 * 根据学院获取校园消息信息,并用分页显示
	 * @param college
	 * @param type	类型:1.新闻,2.通知,0.新闻和通知
	 * @return
	 */
	public PageObject<Campusnews> findByCollege(College college, int type);
	/**
	 * 根据专业获取校园消息信息,并用分页显示
	 * @param major
	 * @param type	类型:1.新闻,2.通知,0.新闻和通知
	 * @return
	 */
	public PageObject<Campusnews> findByMajor(Major major, int type);
	/**
	 * 获取新闻,并用分页显示
	 * @return
	 */
	public PageObject<Campusnews> findNews();
	/**
	 * 获取通知,并用分页显示
	 * @return
	 */
	public PageObject<Campusnews> findNotification();
	/**
	 * 根据用户ID获取校园信息,并用分页显示
	 * @param id
	 * @param type	类型:1.新闻,2.通知,0.新闻和通知
	 * @return
	 */
	public PageObject<Campusnews> findByUserID(int id, int type);
	/**
	 * 从输入流里读取校园消息信息，批量读取
	 * @param inputStream
	 * @throws IOException
	 */
	public void addCampusnewsFromInputStream(InputStream inputStream)
			throws IOException;
}
