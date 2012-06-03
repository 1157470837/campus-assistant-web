package com.techthinker.CAWeb.iwebservice;

import javax.jws.WebParam;
import javax.jws.WebResult;

import com.techthinker.CAWeb.model.UserModel;
/**
 * 用户管理模块的Web Service
 * @author JC@Techthinker.com
 *
 */
public interface IUserWebservice {
	/**
	 * 用于客户端注册
	 * @param user 客户端的请求的用户模型
	 * @return 注册好的用户模型，用户客户端保存用户信息
	 */
	@WebResult(name = "registerReturn")
	public UserModel register(@WebParam(name = "registerUser")UserModel user);
	
	/**
	 * 用户登录
	 * @param email 用户邮箱
	 * @param password 用户密码
	 * @return 登录成功的用户模型
	 */
	@WebResult(name = "loginReturn")
	public UserModel login(@WebParam(name = "email")String email,@WebParam(name = "password")String password);
	
	/**
	 * 同步好友信息，将当前用户的好友信息取出，并采取按页请求，当返回为空是说明没有数据了
	 * @param userId 用户的id
	 * @param pageNum 请求的页数
	 * @return 好友信息模型
	 */
	@WebResult(name = "syncFriendsReturn")
	public UserModel[] syncFriends(@WebParam(name = "userId")int userId,@WebParam(name = "pageNum")int pageNum);
	
	/**
	 * 申请加为好友，向服务器发出添加好友的申请
	 * @param userId 用户的id
	 * @param friendId 要添加的好友id
	 * @return 请求是否成功
	 */
	@WebResult(name = "makeFriendsReturn")
	public boolean requestFriends(@WebParam(name = "userId")int userId,@WebParam(name = "friendId")int friendId);

	/**
	 * 同意加为好友，向服务器发出同意添加好友的申请
	 * @param userId 用户的id
	 * @param friendId 同意添加的好友id
	 * @return 请求是否成功
	 */
	@WebResult(name = "admitFriendsReturn")
	public boolean admitFriends(@WebParam(name = "userId")int userId,@WebParam(name = "friendId")int friendId);
	
	/**
	 * 寻找好友，想服务器请求好友数据
	 * @param userId 用户的id
	 * @param condition 要搜索的好友条件，HQL语句
	 * @return 服务器返回的好友数据模型
	 */
	@WebResult(name = "findFriendsReturn")
	public UserModel[] findFriends(@WebParam(name = "userId")int userId,@WebParam(name = "condition")String condition);
}
