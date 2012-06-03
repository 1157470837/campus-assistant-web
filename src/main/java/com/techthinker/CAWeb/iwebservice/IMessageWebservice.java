package com.techthinker.CAWeb.iwebservice;

import javax.jws.WebParam;
import javax.jws.WebResult;

import com.techthinker.CAWeb.model.MessageModel;

public interface IMessageWebservice {
	/**
	 * 同步聊天室聊天内容，将对应聊天室的聊天内容取出，当返回为空是说明没有数据了
	 * @param chatroomId 聊天室id
	 * @param lastTime 最后更新时间
	 * @return 聊天记录
	 */
	@WebResult(name = "syncMessageReturn")
	public MessageModel[] syncChatroomMessage(@WebParam(name = "chatroomId")int chatroomId,@WebParam(name = "lastTime")long lastTime);
	
	/**
	 * 同步好友聊天内容，将对对应用户的聊天内容取出，当返回为空是说明没有数据了
	 * @param userId 用户id
	 * @param lastTime 最后更新时间
	 * @return 聊天记录
	 */
	@WebResult(name = "syncMessageReturn")
	public MessageModel[] syncUserMessage(@WebParam(name = "userId")int userId,@WebParam(name = "lastTime")long lastTime);
	/**
	 * 客户端向服务器发送一条聊天记录
	 * @param messageModel 聊天记录
	 * @return 服务器是否添加成功
	 */
	public boolean postMessage(@WebParam(name = "message")MessageModel messageModel);
}
