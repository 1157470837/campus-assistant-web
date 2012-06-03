package com.techthinker.CAWeb.iwebservice;

import javax.jws.WebParam;
import javax.jws.WebResult;

import com.techthinker.CAWeb.model.SpotcommentModel;

/**
 * 校园公共模块的Web Service
 * 
 * @author JC@Techthinker.com
 * 
 */
public interface ISpotcommentWebservice {
	/**
	 * 向服务器请求简短的用户评论，用于界面展示
	 * @param scenicspotId 评论对应的景点Id
	 * @return 景点信息模型
	 */
	@WebResult(name = "pullBreifCommentReturn")
	public SpotcommentModel[] pullBreifComment(@WebParam(name = "scenicspotId")int scenicspotId);
	
	/**
	 * 向服务器按页请求的用户详细评论，当返回为空是说明没有数据了</br>
	 * 每页数据的数量由SystemContext指定
	 * @param scenicspotId 评论对应的景点Id
	 * @param pageNum 请求的页数
	 * @return 景点信息模型
	 */
	@WebResult(name = "pullCommentReturn")
	public SpotcommentModel[] pullComment(@WebParam(name = "scenicspotId")int scenicspotId,@WebParam(name = "pageNum")int pageNum);
	
	@WebResult(name = "addCommentReturn")
	public boolean addComment(@WebParam(name = "spotcomment")SpotcommentModel spotcomment);
}
