package com.techthinker.CAWeb.iservice;

import java.sql.Blob;

import com.techthinker.CAWeb.persistence.Spotcomment;

public interface ISpotcommentService {
	
	/**
	 * 添加一条新的景点评论
	 * @param userId 用户Id
	 * @param scenicspotId 景点Id
	 * @param content 评论内容
	 * @param rating 评分（0-100）
	 * @param impression 上传的印象图片 
	 * @return 添加好的景点评论
	 */
	public Spotcomment addSpotCommentByUserId(int userId,int scenicspotId,String content,int rating,Blob impression);
}
