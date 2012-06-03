package com.techthinker.CAWeb.service;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techthinker.CAWeb.exception.ScenicspotException;
import com.techthinker.CAWeb.exception.SpotcommentException;
import com.techthinker.CAWeb.exception.UserException;
import com.techthinker.CAWeb.idao.ISpotcommentDao;
import com.techthinker.CAWeb.iservice.IScenicspotService;
import com.techthinker.CAWeb.iservice.ISpotcommentService;
import com.techthinker.CAWeb.iservice.IUserService;
import com.techthinker.CAWeb.persistence.Scenicspot;
import com.techthinker.CAWeb.persistence.Spotcomment;
import com.techthinker.CAWeb.persistence.User;

@Service("spotcommentService")
public class SpotcommentService implements ISpotcommentService {
	private IScenicspotService scenicspotService;
	private IUserService userService;

	/**
	 * @return the userService
	 */
	public IUserService getUserService() {
		return userService;
	}

	/**
	 * @param userService
	 *            the userService to set
	 */
	@Resource
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	private ISpotcommentDao spotcommentDao;

	/**
	 * @return the scenicspotService
	 */
	public IScenicspotService getScenicspotService() {
		return scenicspotService;
	}

	/**
	 * @param scenicspotService
	 *            the scenicspotService to set
	 */
	@Resource
	public void setScenicspotService(IScenicspotService scenicspotService) {
		this.scenicspotService = scenicspotService;
	}

	/**
	 * @return the spotcommentDao
	 */
	public ISpotcommentDao getSpotcommentDao() {
		return spotcommentDao;
	}

	/**
	 * @param spotcommentDao
	 *            the spotcommentDao to set
	 */
	@Resource
	public void setSpotcommentDao(ISpotcommentDao spotcommentDao) {
		this.spotcommentDao = spotcommentDao;
	}

	@Override
	public Spotcomment addSpotCommentByUserId(int userId, int scenicspotId,
			String content, int rating, Blob impression) {

		// 首先验证userId是否存在
		User user = userService.load(userId);
		if (user == null)
			throw new UserException("不存在该用户");
		// 再验证scenicspotId是否存在
		Scenicspot scenicspot = scenicspotService
				.checkScenicspotsIdExists(scenicspotId);
		if (scenicspot == null)
			throw new ScenicspotException("不存在景点");
		Timestamp pubdate = new Timestamp(new Date().getTime());
		Spotcomment spotcomment = spotcommentDao.add(new Spotcomment(user,
				scenicspot, content, pubdate, rating, impression));
		if (spotcomment == null)
			throw new SpotcommentException("添加评论失败");
		return spotcomment;
	}

}
