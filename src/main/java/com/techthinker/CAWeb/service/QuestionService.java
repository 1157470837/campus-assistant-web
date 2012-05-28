package com.techthinker.CAWeb.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techthinker.CAWeb.idao.ITempIndexDao;
import com.techthinker.CAWeb.iservice.IQuesitonService;

@Service("questionService")
public class QuestionService implements IQuesitonService {
	private ITempIndexDao tempIndexDao;

	/**
	 * @return the tempIndexDao
	 */
	public ITempIndexDao getTempIndexDao() {
		return tempIndexDao;
	}

	/**
	 * @param tempIndexDao
	 *            the tempIndexDao to set
	 */
	@Resource
	public void setTempIndexDao(ITempIndexDao tempIndexDao) {
		this.tempIndexDao = tempIndexDao;
	}

}
