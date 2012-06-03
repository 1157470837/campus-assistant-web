package com.techthinker.CAWeb.iwebservice;

import javax.jws.WebParam;
import javax.jws.WebResult;

import com.techthinker.CAWeb.model.ChatroomModel;
/**
 * 聊天室模块的Web Service
 * @author JC@Techthinker.com
 *
 */
public interface IUserTypeWebservice {
	/**
	 * 同步用户权限信息，将所有权限信息取出，并采取按页请求，当返回为空是说明没有数据了</br>
	 * 每页数据的数量由SystemContext指定
	 * @param pageNum 请求的页数
	 * @return 权限信息
	 */
	@WebResult(name = "syncChatroomReturn")
	public ChatroomModel[] syncChatroom(@WebParam(name = "pageNum")int pageNum);
	
}
