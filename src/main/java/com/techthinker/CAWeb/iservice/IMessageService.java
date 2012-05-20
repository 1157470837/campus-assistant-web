package com.techthinker.CAWeb.iservice;

import java.util.Date;
import java.util.List;

import com.techthinker.CAWeb.util.PageObject;
import com.techthinker.CAWeb.vo.Message;

public interface IMessageService {
	/**
	 * 添加消息
	 * 判断消息名是否唯一，如果不唯一抛出异常
	 * @param Message 要添加的消息
	 */
	public void add(Message message);
	/**
	 * 更新消息
	 * 不能更新消息名
	 * @param Message 要更新的消息
	 */
	public void update(Message message);
	/**
	 * 根据ID删除消息
	 * @param id
	 */
	public void delete(int id);
	/**
	 * 根据消息类型删除消息    1：聊天室消息；2：用户消息
	 * @param toType
	 */
	public void deleteByType(int toType);
	/**
	 * 根据消息id来获取相应的消息
	 * @param id 需要获取消息的主键id
	 * @return 需要获取的消息
	 */
	public Message load(int id);
	/**
	 * 获取所有消息列表
	 * @return 所有消息列表
	 */
	public List<Message> list();
	/**
	 * 根据分页获取消息信息
	 * @param pageOffset 从哪一个位置开始查询
	 * @param pageSize 每页显示多少条
	 * @return
	 */
	public PageObject<Message> find(int userId,
									Date pubDate,
									int toChatroomId,
									int toUserId,
									int toType);
}
