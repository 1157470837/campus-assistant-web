package com.techthinker.CAWeb.iwebservice;

import javax.jws.WebParam;
import javax.jws.WebResult;

import com.techthinker.CAWeb.model.UserModel;

/**
 * 聊天室模块的Web Service
 * @author JC@Techthinker.com
 *
 *
 *
 *
 */
public interface IEtartWebservice {
	/**
	 * 寻找好友，向服务器请求推荐好友数据
	 * @param userId 用户的id
	 * @return 服务器返回的好友数据模型
	 */
	@WebResult(name = "recommendFriendsReturn")
	public UserModel[] recommendFriends(@WebParam(name = "userId")int userId);
	
	/**
	 * 智能聊天，想服务器提交聊天内容
	 * @param chatContent 智能聊天的请求内容
	 * @return 服务器返回的处理结果
	 */
	@WebResult(name = "etartChatReturn")
	public String etartChat(@WebParam(name = "chatContent")String chatContent);
}
