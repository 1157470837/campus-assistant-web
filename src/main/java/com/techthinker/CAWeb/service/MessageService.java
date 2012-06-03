package com.techthinker.CAWeb.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techthinker.CAWeb.idao.IChatroomDao;
import com.techthinker.CAWeb.idao.IMessageDao;
import com.techthinker.CAWeb.idao.IUserDao;
import com.techthinker.CAWeb.iservice.IMessageService;
import com.techthinker.CAWeb.persistence.Chatroom;
import com.techthinker.CAWeb.persistence.Message;
import com.techthinker.CAWeb.persistence.User;
import com.techthinker.CAWeb.util.PageObject;

@Service("messageService")
public class MessageService implements IMessageService {

	private IMessageDao messageDao;
	private IUserDao userDao;
	private IChatroomDao chatroomDao;
	public IUserDao getUserDao() {
		return userDao;
	}

	@Resource
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}


	public IChatroomDao getChatroomDao() {
		return chatroomDao;
	}

	@Resource
	public void setChatroomDao(IChatroomDao chatroomDao) {
		this.chatroomDao = chatroomDao;
	}

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
	public PageObject<Message> find(Message msg) {
		
//		StringBuilder hql = new StringBuilder("from Message where ");
//		if(msg != 0) {
//			hql.append("userId = " + userId);
//		}
//		if(pubDate != null) {
//			hql.append("pubDate = " + pubDate);
//		}
//		if(toChatroomId != 0) {
//			hql.append("toChatroomId = " + toChatroomId);
//		}
//		if(toUserId != 0) {
//			hql.append("toUserId = " + toUserId);
//		}
//		if(toType != 0) {
//			hql.append("toType = " + toType);
//		}
//		return this.messageDao.find(hql.toString());
		return null;
	}

	@Override 
	public Message load(int id) {
		return this.messageDao.load(id);
	}

	@Override
	public List<Message> list() {
		return this.messageDao.list("from Message");
	}

	@Override
	public void addMessageFromInputStream(InputStream inputStream)
			throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(
				inputStream));
		String r = br.readLine();
		Message msg = null;
		User userByUserId = null;
		User userByTouserId = null;
		Chatroom croom = null;
		int toType = 0;
		
		r = br.readLine();
		while( r!=null ){
			if(r.contains("----------")){
				r = br.readLine();
			}
			msg = new Message();
			toType = Integer.parseInt(r.trim());
			msg.setTotype(toType);
			userByUserId = userDao.loadByHql("from User where username = ?", br.readLine().trim());
			msg.setUserByUserId(userByUserId);
			msg.setContent(br.readLine().trim());
			msg.setPubdate(Timestamp.valueOf(br.readLine().trim()+" 00:00:00"));
			if(toType == 1){
				croom = chatroomDao.loadByHql("from Chatroom where chatroomName = ?", br.readLine().trim());
				msg.setChatroom(croom);
			}else if(toType ==2){
				userByTouserId = userDao.loadByHql("from User where username = ?", br.readLine().trim());
				 msg.setUserByTouserId(userByTouserId);
			}
			
			messageDao.add(msg);

			r = br.readLine();
		}

	}

}
