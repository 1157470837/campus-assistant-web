package com.techthinker.CAWeb.iservice;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


import com.techthinker.CAWeb.util.PageObject;
import com.techthinker.CAWeb.vo.Chatroom;

public interface IChatroomService {
	/**
	 * 添加聊天室
	 * 判断聊天室名是否唯一，如果不唯一抛出异常
	 * @param Chatroom 要添加的聊天室
	 */
	public void add(Chatroom chatroom);
	/**
	 * 更新聊天室
	 * 不能更新聊天室名
	 * @param Chatroom 要更新的聊天室
	 */
	public void update(Chatroom chatroom);
	/**
	 * 删除聊天室
	 * @param id
	 */
	public void delete(int id);
	/**
	 * 根据聊天室id来获取相应的聊天室
	 * @param id 需要获取聊天室的主键id
	 * @return 需要获取的聊天室
	 */
	public Chatroom load(int id);
	/**
	 * 获取所有聊天室列表
	 * @return 所有聊天室列表
	 */
	public List<Chatroom> list();

	/**
	 * 根据分页获取聊天室信息
	 * @param pageOffset 从哪一个位置开始查询
	 * @param pageSize 每页显示多少条
	 * @return
	 */
	public PageObject<Chatroom> find(String chatroomName);
	/**
	 * 根据聊天室名获取某个聊天室
	 * @param chatroomName
	 * @return
	 */
	public Chatroom loadByChatroomname(String chatroomName);
	/**
	 * 检查聊天室是否存在
	 * @param chatroomName
	 * @return
	 */
	public boolean checkChatroom(String chatroomName);
	/**
	 * 从输入流里读取聊天室信息，批量读取
	 * @param inputStream
	 * @throws IOException
	 */
	public void addCollegeFromInputStream(InputStream inputStream)
			throws IOException;
}
