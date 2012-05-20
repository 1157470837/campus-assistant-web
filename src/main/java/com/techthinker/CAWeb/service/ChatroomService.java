package com.techthinker.CAWeb.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techthinker.CAWeb.exception.ChatroomException;
import com.techthinker.CAWeb.idao.IChatroomDao;
import com.techthinker.CAWeb.iservice.IChatroomService;
import com.techthinker.CAWeb.util.PageObject;
import com.techthinker.CAWeb.vo.Chatroom;

@Service("chatroomService")
public class ChatroomService implements IChatroomService {

	private IChatroomDao chatroomDao;
	public IChatroomDao getChatroomDao() {
		return chatroomDao;
	}

	@Resource
	public void setChatroomDao(IChatroomDao chatroomDao) {
		this.chatroomDao = chatroomDao;
	}

	@Override
	public void add(Chatroom chatroom) {
		Chatroom tc = this.loadByChatroomname(chatroom.getChatroomName());
		if(tc != null) throw new ChatroomException("要添加的聊天室已经存在，不能添加");
		this.chatroomDao.add(chatroom);

	}

	@Override
	public void update(Chatroom chatroom) {
		this.chatroomDao.update(chatroom);

	}

	@Override
	public void delete(int id) {
		this.chatroomDao.delete(id);

	}

	@Override
	public Chatroom load(int id) {
		return this.chatroomDao.load(id);
	}

	@Override
	public List<Chatroom> list() {
		return this.chatroomDao.list("from Chatroom");
	}

	@Override
	public PageObject<Chatroom> find(String chatroomName) {
		if(chatroomName == null || "".equals(chatroomName.trim())){
			return this.chatroomDao.find("from Chatromm");
		}else{
			return chatroomDao.find("from Chatroom where chatroomName like ?",
					new Object[]{"%"+chatroomName+"%"});
		}
	}

	@Override
	public Chatroom loadByChatroomname(String chatroomName) {
		return this.chatroomDao.loadByHql("from Chatroom where chatroomName = ?", chatroomName);
	}

	@Override
	public boolean checkChatroom(String chatroomName) {
		long count = (Long)chatroomDao.loadObjByHQL("select count(*) from Chatroom where chatroomName=?",chatroomName);
		return count>0?true:false;
	}

	@Override
	public void addCollegeFromInputStream(InputStream inputStream)
			throws IOException {
		// TODO Auto-generated method stub

	}

}
