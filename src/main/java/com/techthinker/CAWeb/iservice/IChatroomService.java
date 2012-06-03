package com.techthinker.CAWeb.iservice;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.techthinker.CAWeb.persistence.Chatroom;
import com.techthinker.CAWeb.persistence.Message;
import com.techthinker.CAWeb.persistence.User;
import com.techthinker.CAWeb.util.PageObject;

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
	/**
	 * 用户进入聊天室
	 * @param user
	 * @param roomID
	 */
	public void enterRoom(User user, int roomID);
	/**
	 * 用户推出聊天室
	 * @param userID
	 * @param roomID
	 */
	public void exitRoom(int userID,  int roomID);
	/**
	 * 发送消息
	 * @param type	1：向聊天室发送消息	2：向用户发送消息
	 * @param name	有type决定，若type=1，则identity是聊天室的ID号；若type=2，则identity是用户的ID号
	 * @param user	发送消息的用户
	 * @param message	消息内容
	 */
	public void sendMessageToRoom(int type,int identity,User user, String message);
	/**
	 * 取出指定Id的聊天室中登入的用户
	 * @param roomId	聊天室ID
	 * @return List<User>
	 */
	public List<User> getUsersAvailableInRoom(int roomId);
	/**
	 * 取出指定Id的聊天室中的消息
	 * @param roomId  聊天室ID
	 * @return List<Message>
	 */
	List<Message> getMessagesInRoom(int roomId);
	public void addChatroomFromInputStream(InputStream inputStream)
			throws IOException;
}
