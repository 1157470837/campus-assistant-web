package com.techthinker.CAWeb.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techthinker.CAWeb.exception.ChatroomException;
import com.techthinker.CAWeb.idao.IChatroomDao;
import com.techthinker.CAWeb.idao.ICollegeDao;
import com.techthinker.CAWeb.idao.IGradeDao;
import com.techthinker.CAWeb.idao.IMajorDao;
import com.techthinker.CAWeb.iservice.IChatroomService;
import com.techthinker.CAWeb.util.PageObject;
import com.techthinker.CAWeb.vo.Chatroom;
import com.techthinker.CAWeb.vo.College;
import com.techthinker.CAWeb.vo.Grade;
import com.techthinker.CAWeb.vo.Major;

@Service("chatroomService")
public class ChatroomService implements IChatroomService {

	private IChatroomDao chatroomDao;
	private IGradeDao gradeDao;
	private IMajorDao majorDao;
	private ICollegeDao colllegeDao;

	public ICollegeDao getColllegeDao() {
		return colllegeDao;
	}

	@Resource
	public void setColllegeDao(ICollegeDao colllegeDao) {
		this.colllegeDao = colllegeDao;
	}

	public IMajorDao getMajorDao() {
		return majorDao;
	}

	@Resource
	public void setMajorDao(IMajorDao majorDao) {
		this.majorDao = majorDao;
	}

	private ICollegeDao collegeDao;

	public ICollegeDao getCollegeDao() {
		return collegeDao;
	}

	@Resource
	public void setCollegeDao(ICollegeDao collegeDao) {
		this.collegeDao = collegeDao;
	}

	public IGradeDao getGardeDao() {
		return gradeDao;
	}

	@Resource
	public void setGardeDao(IGradeDao gardeDao) {
		this.gradeDao = gardeDao;
	}

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
		if (tc != null)
			throw new ChatroomException("要添加的聊天室已经存在，不能添加");
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
		if (chatroomName == null || "".equals(chatroomName.trim())) {
			return this.chatroomDao.find("from Chatromm");
		} else {
			return chatroomDao.find("from Chatroom where chatroomName like ?",
					new Object[] { "%" + chatroomName + "%" });
		}
	}

	@Override
	public Chatroom loadByChatroomname(String chatroomName) {
		return this.chatroomDao.loadByHql(
				"from Chatroom where chatroomName = ?", chatroomName);
	}

	@Override
	public boolean checkChatroom(String chatroomName) {
		long count = (Long) chatroomDao.loadObjByHQL(
				"select count(*) from Chatroom where chatroomName=?",
				chatroomName);
		return count > 0 ? true : false;
	}

	@Override
	public void addChatroomFromInputStream(InputStream inputStream)
			throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				inputStream));
		String r = br.readLine();

		College c = null;
		Major m = null;
		Grade g = null;
		String majorName, gradeName, collegeName;
		Chatroom cr = null;

		r = br.readLine();
		while (r != null) {

			if (r.contains("----------"))
				r = br.readLine();

			String[] infos = r.split(",");
			System.out.println(infos[0] + "|" + infos[1]);
			if (infos[1].equals("1")) {
				cr = new Chatroom();
				cr.setChatroomName(infos[0].trim());
				cr.setLevel(1);
				cr.setParentroomId(0);
				chatroomDao.add(cr);
			} else if (infos[1].equals("2")) {
				cr = new Chatroom();
				collegeName = infos[0].trim();
				cr.setChatroomName(collegeName);
				c = collegeDao.loadByHql("from College where collegeName =?",
						collegeName);
				cr.setCollege(c);
				cr.setLevel(2);
				cr.setParentroomId(chatroomDao.loadByHql(
						"from Chatroom where level = 1").getChatroomId());
				chatroomDao.add(cr);
			} else if (infos[1].equals("3")) {
				cr = new Chatroom();
				majorName = infos[0].trim();
				m = majorDao.loadByHql("from Major where majorName=? ",
						majorName);
				cr.setChatroomName(majorName);
				cr.setLevel(3);
				cr.setParentroomId(chatroomDao
						.loadByHql(
								"from Chatroom c where c.college.collegeId = ? and level = 2",
								m.getCollege().getCollegeId()).getChatroomId());
				cr.setMajor(m);
				c = collegeDao.loadByHql("from College where collegeName=?", m
						.getCollege().getCollegeName());
				cr.setCollege(c);
				chatroomDao.add(cr);
			} else if (infos[1].equals("4")) {
				// majorName = infos[0].trim();
				for (int i = 0; i < 4; i++) {
					cr = new Chatroom();
					gradeName = br.readLine();
					g = new Grade();
					g = gradeDao.loadByHql("from Grade where gradeName=? ",
							gradeName);
					System.out.println(g.getGradeName());
					cr.setChatroomName(gradeName);
					cr.setLevel(4);
					cr.setParentroomId(chatroomDao
							.loadByHql(
									"from Chatroom c where c.major.majorId = ? and level = ?",
									new Object[] {
											g.getMajor().getMajorId(), 3 })
							.getChatroomId());
					cr.setGrade(g);
					m = majorDao.loadByHql("from Major where majorName=? ", g
							.getMajor().getMajorName());
					cr.setMajor(m);
					c = collegeDao.loadByHql(
							"from College where collegeName =?", g.getCollege()
									.getCollegeName());
					cr.setCollege(c);

					chatroomDao.add(cr);

				}
			}

			r = br.readLine();
		}
	}

}
