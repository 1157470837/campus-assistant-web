package com.techthinker.CAWeb.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techthinker.CAWeb.idao.IMessageDao;
import com.techthinker.CAWeb.iservice.IMessageService;
import com.techthinker.CAWeb.util.PageObject;
import com.techthinker.CAWeb.vo.Message;

@Service("messageService")
public class MessageService implements IMessageService {

	private IMessageDao messageDao;
	public IMessageDao getMessageDao() {
		return messageDao;
	}

	@Resource
	public void setMessageDao(IMessageDao messageDao) {
		this.messageDao = messageDao;
	}

	@Override
	public void add(Message message) {
		this.messageDao.add(message);
	}



	@Override
	public void update(Message message) {
		this.messageDao.update(message);
		
	}

	@Override
	public void delete(int id) {
		this.messageDao.delete(id);

	}

	@Override
	public void deleteByType(int toType) {
		List<Message> lists = this.messageDao.list("from Message where totype = ?", toType);
		for(Message msg: lists){
			this.messageDao.delete(msg.getMessageId());
		}
		
	}

	@Override
	public PageObject<Message> find(int userId, Date pubDate, int toChatroomId,
			int toUserId, int toType) {
		StringBuilder hql = new StringBuilder("from Message where ");
		if(userId != 0) {
			hql.append("userId = " + userId);
		}
		if(pubDate != null) {
			hql.append("pubDate = " + pubDate);
		}
		if(toChatroomId != 0) {
			hql.append("toChatroomId = " + toChatroomId);
		}
		if(toUserId != 0) {
			hql.append("toUserId = " + toUserId);
		}
		if(toType != 0) {
			hql.append("toType = " + toType);
		}
		return this.messageDao.find(hql.toString());
	}

	@Override
	public Message load(int id) {
		return this.messageDao.load(id);
	}

	@Override
	public List<Message> list() {
		return this.messageDao.list("from Message");
	}



}
