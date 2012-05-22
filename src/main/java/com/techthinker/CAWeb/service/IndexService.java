package com.techthinker.CAWeb.service;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.stereotype.Service;

import com.techthinker.CAWeb.idao.ICampusnewsDao;
import com.techthinker.CAWeb.idao.ICollegeDao;
import com.techthinker.CAWeb.idao.IGradeDao;
import com.techthinker.CAWeb.idao.IIntentDao;
import com.techthinker.CAWeb.idao.IMajorDao;
import com.techthinker.CAWeb.idao.IQuestionDao;
import com.techthinker.CAWeb.idao.IScenicspotDao;
import com.techthinker.CAWeb.idao.ITempIndexDao;
import com.techthinker.CAWeb.idao.IUserDao;
import com.techthinker.CAWeb.index.SolrContext;
import com.techthinker.CAWeb.iservice.IIndexService;
import com.techthinker.CAWeb.util.IndexUtil;
import com.techthinker.CAWeb.vo.Campusnews;
import com.techthinker.CAWeb.vo.College;
import com.techthinker.CAWeb.vo.Grade;
import com.techthinker.CAWeb.vo.IndexField;
import com.techthinker.CAWeb.vo.Intent;
import com.techthinker.CAWeb.vo.Major;
import com.techthinker.CAWeb.vo.Question;
import com.techthinker.CAWeb.vo.Scenicspot;
import com.techthinker.CAWeb.vo.TempIndex;
import com.techthinker.CAWeb.vo.User;

@Service("indexService")
public class IndexService implements IIndexService {
	private ITempIndexDao tempIndexDao;
	private IUserDao userDao;
	private ICampusnewsDao campusnewsDao;
	private ICollegeDao collegeDao;
	private IMajorDao majorDao;
	private IGradeDao gradeDao;
	private IQuestionDao questionDao;
	private IScenicspotDao scenicspotDao;
	private IIntentDao intentDao;

	/**
	 * @return the userDao
	 */
	public IUserDao getUserDao() {
		return userDao;
	}

	/**
	 * @param userDao
	 *            the userDao to set
	 */
	@Resource
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * @return the campusnewsDao
	 */
	public ICampusnewsDao getCampusnewsDao() {
		return campusnewsDao;
	}

	/**
	 * @param campusnewsDao
	 *            the campusnewsDao to set
	 */
	@Resource
	public void setCampusnewsDao(ICampusnewsDao campusnewsDao) {
		this.campusnewsDao = campusnewsDao;
	}

	/**
	 * @return the collegeDao
	 */
	public ICollegeDao getCollegeDao() {
		return collegeDao;
	}

	/**
	 * @param collegeDao
	 *            the collegeDao to set
	 */
	@Resource
	public void setCollegeDao(ICollegeDao collegeDao) {
		this.collegeDao = collegeDao;
	}

	/**
	 * @return the majorDao
	 */
	public IMajorDao getMajorDao() {
		return majorDao;
	}

	/**
	 * @param majorDao
	 *            the majorDao to set
	 */
	@Resource
	public void setMajorDao(IMajorDao majorDao) {
		this.majorDao = majorDao;
	}

	/**
	 * @return the gradeDao
	 */
	public IGradeDao getGradeDao() {
		return gradeDao;
	}

	/**
	 * @param gradeDao
	 *            the gradeDao to set
	 */
	@Resource
	public void setGradeDao(IGradeDao gradeDao) {
		this.gradeDao = gradeDao;
	}

	/**
	 * @return the questionDao
	 */
	public IQuestionDao getQuestionDao() {
		return questionDao;
	}

	/**
	 * @param questionDao
	 *            the questionDao to set
	 */
	@Resource
	public void setQuestionDao(IQuestionDao questionDao) {
		this.questionDao = questionDao;
	}

	/**
	 * @return the intentDao
	 */
	public IIntentDao getIntentDao() {
		return intentDao;
	}

	/**
	 * @param intentDao
	 *            the intentDao to set
	 */
	@Resource
	public void setIntentDao(IIntentDao intentDao) {
		this.intentDao = intentDao;
	}

	/**
	 * @return the scenicspotDao
	 */
	public IScenicspotDao getScenicspotDao() {
		return scenicspotDao;
	}

	/**
	 * @param scenicspotDao
	 *            the scenicspotDao to set
	 */
	@Resource
	public void setScenicspotDao(IScenicspotDao scenicspotDao) {
		this.scenicspotDao = scenicspotDao;
	}

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

	@Override
	public void addIndex(IndexField field) {
		try {
			SolrContext.getServer().addBean(field);
			SolrContext.getServer().commit();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteIndex(String id) {
		try {
			SolrContext.getServer().deleteById(id);
			SolrContext.getServer().commit();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateIndex(IndexField fields) {
		try {
			SolrContext.getServer().deleteById(fields.getId());
			SolrContext.getServer().addBean(fields);
			SolrContext.getServer().commit();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateSetIndex() {
		try {
			List<TempIndex> tis = tempIndexDao.list("from TempIndex");
			for (TempIndex ti : tis) {
				if (ti.getObjType().equals(IndexUtil.ACTION_USER)) {
					User user = userDao.load(ti.getObjId());
					indexUser(user, ti.getOperator());
				} else if (ti.getObjType().equals(IndexUtil.ACTION_CAMPUSNEWS)) {
					Campusnews campusnews = campusnewsDao.load(ti.getObjId());
					indexCampusnews(campusnews, ti.getOperator());
				} else if (ti.getObjType().equals(IndexUtil.ACTION_COLLEGE)) {
					College college = collegeDao.load(ti.getObjId());
					indexCollege(college, ti.getOperator());
				} else if (ti.getObjType().equals(IndexUtil.ACTION_GRADE)) {
					Grade grade = gradeDao.load(ti.getObjId());
					indexGrade(grade, ti.getOperator());
				} else if (ti.getObjType().equals(IndexUtil.ACTION_INTENT)) {
					Intent intent = intentDao.load(ti.getObjId());
					indexIntent(intent, ti.getOperator());
				} else if (ti.getObjType().equals(IndexUtil.ACTION_MAJOR)) {
					Major major = majorDao.load(ti.getObjId());
					indexMajor(major, ti.getOperator());
				} else if (ti.getObjType().equals(IndexUtil.ACTION_QUESTION)) {
					Question question = questionDao.load(ti.getObjId());
					indexQuestion(question, ti.getOperator());
				} else if (ti.getObjType().equals(IndexUtil.ACTION_SCENICSPOT)) {
					Scenicspot scenicspot = scenicspotDao.load(ti.getObjId());
					indexScenicspot(scenicspot, ti.getOperator());
				}
			}
			SolrContext.getServer().commit();
			tempIndexDao.delAll();
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateCommitIndex() {
		updateSetIndex();
		tempIndexDao.delAll();
	}

	@Override
	public void updateReconstructorIndex() {
		/**
		 * 将数据库中的所有对象取出，创建相应的IndexField完成索引的重构
		 */
		try {
			SolrContext.getServer().deleteByQuery("*:*");
			List<User> users = userDao.list("from User");
			indexUsers(users, IndexUtil.OP_ADD);
			List<College> colleges = collegeDao.list("from College");
			indexCollege(colleges, IndexUtil.OP_ADD);
			List<Major> majors = majorDao.list("from Major");
			indexMajors(majors, IndexUtil.OP_ADD);
			List<Grade> grades = gradeDao.list("from Grade");
			indexGrades(grades, IndexUtil.OP_ADD);
			List<Campusnews> campusnewses = campusnewsDao
					.list("from Campusnews");
			indexCampusnewses(campusnewses, IndexUtil.OP_ADD);
			List<Question> questions = questionDao.list("from Question");
			indexQuestions(questions, IndexUtil.OP_ADD);
			List<Intent> intents = intentDao.list("from Intent");
			indexIntents(intents, IndexUtil.OP_ADD);
			List<Scenicspot> scenicspots = scenicspotDao
					.list("from Scenicspot");
			indexScenicspots(scenicspots, IndexUtil.OP_ADD);
			SolrContext.getServer().commit();
			tempIndexDao.delAll();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void indexUsers(List<User> users, int operator) {
		for (User user : users) {
			indexUser(user, operator);
		}
	}

	private void indexCollege(List<College> colleges, int operator) {
		for (College college : colleges) {
			indexCollege(college, operator);
		}
	}

	private void indexMajors(List<Major> majors, int operator) {
		for (Major major : majors) {
			indexMajor(major, operator);
		}
	}

	private void indexGrades(List<Grade> grades, int operator) {
		for (Grade grade : grades) {
			indexGrade(grade, operator);
		}
	}

	private void indexCampusnewses(List<Campusnews> campusnewses, int operator) {
		for (Campusnews campusnewse : campusnewses) {
			indexCampusnews(campusnewse, operator);
		}
	}

	private void indexQuestions(List<Question> questions, int operator) {
		for (Question question : questions) {
			indexQuestion(question, operator);
		}
	}

	private void indexIntents(List<Intent> intents, int operator) {
		for (Intent intent : intents) {
			indexIntent(intent, operator);
		}
	}

	private void indexScenicspots(List<Scenicspot> scenicspots, int operator) {
		for (Scenicspot scenicspot : scenicspots) {
			indexScenicspot(scenicspot, operator);
		}
	}

	private void indexQuestion(Question question, int operator) {
		switch (operator) {
		case IndexUtil.OP_ADD:
			IndexField field1 = IndexUtil.createIndexField(
					question.getQuestionId(), question.getContent(),
					question.getAnswer(), IndexUtil.ACTION_QUESTION);
			addIndex(field1);
			break;
		case IndexUtil.OP_DEL:
			deleteIndex(IndexUtil.ACTION_QUESTION + "_"
					+ question.getQuestionId());
			break;
		case IndexUtil.OP_UPDATE:
			IndexField field2 = IndexUtil.createIndexField(
					question.getQuestionId(), question.getContent(),
					question.getAnswer(), IndexUtil.ACTION_QUESTION);
			updateIndex(field2);
			break;
		}
	}

	private void indexMajor(Major major, int operator) {
		switch (operator) {
		case IndexUtil.OP_ADD:
			IndexField field1 = IndexUtil.createIndexField(major.getMajorId(),
					major.getMajorName(), major.getDescription(),
					IndexUtil.ACTION_MAJOR);
			addIndex(field1);
			break;
		case IndexUtil.OP_DEL:
			deleteIndex(IndexUtil.ACTION_MAJOR + "_" + major.getMajorId());
			break;
		case IndexUtil.OP_UPDATE:
			IndexField field2 = IndexUtil.createIndexField(major.getMajorId(),
					major.getMajorName(), major.getDescription(),
					IndexUtil.ACTION_MAJOR);
			updateIndex(field2);
			break;
		}
	}

	private void indexIntent(Intent intent, int operator) {
		switch (operator) {
		case IndexUtil.OP_ADD:
			IndexField field1 = IndexUtil.createIndexField(
					intent.getIntent_id(), intent.getBrief(),
					intent.getExtension(), IndexUtil.ACTION_INTENT);
			addIndex(field1);
			break;
		case IndexUtil.OP_DEL:
			deleteIndex(IndexUtil.ACTION_INTENT + "_" + intent.getIntent_id());
			break;
		case IndexUtil.OP_UPDATE:
			IndexField field2 = IndexUtil.createIndexField(
					intent.getIntent_id(), intent.getBrief(),
					intent.getExtension(), IndexUtil.ACTION_INTENT);
			updateIndex(field2);
			break;
		}
	}

	private void indexGrade(Grade grade, int operator) {
		switch (operator) {
		case IndexUtil.OP_ADD:
			IndexField field1 = IndexUtil.createIndexField(grade.getGradeId(),
					grade.getGradeName(), grade.getDescription(),
					IndexUtil.ACTION_GRADE);
			addIndex(field1);
			break;
		case IndexUtil.OP_DEL:
			deleteIndex(IndexUtil.ACTION_GRADE + "_" + grade.getGradeId());
			break;
		case IndexUtil.OP_UPDATE:
			IndexField field2 = IndexUtil.createIndexField(grade.getGradeId(),
					grade.getGradeName(), grade.getDescription(),
					IndexUtil.ACTION_GRADE);
			updateIndex(field2);
			break;
		}
	}

	private void indexCollege(College college, int operator) {
		switch (operator) {
		case IndexUtil.OP_ADD:
			IndexField field1 = IndexUtil.createIndexField(
					college.getCollegeId(), college.getCollegeName(),
					college.getDescription(), IndexUtil.ACTION_COLLEGE);
			addIndex(field1);
			break;
		case IndexUtil.OP_DEL:
			deleteIndex(IndexUtil.ACTION_COLLEGE + "_" + college.getCollegeId());
			break;
		case IndexUtil.OP_UPDATE:
			IndexField field2 = IndexUtil.createIndexField(
					college.getCollegeId(), college.getCollegeName(),
					college.getDescription(), IndexUtil.ACTION_COLLEGE);
			updateIndex(field2);
			break;
		}
	}

	private void indexCampusnews(Campusnews campusnews, int operator) {
		switch (operator) {
		case IndexUtil.OP_ADD:
			IndexField field1 = IndexUtil.createIndexField(
					campusnews.getCampusnewId(),
					(campusnews.getNewstype() == 1) ? "新闻" : "通知",
					campusnews.getContent(), IndexUtil.ACTION_CAMPUSNEWS);
			addIndex(field1);
			break;
		case IndexUtil.OP_DEL:
			deleteIndex(IndexUtil.ACTION_CAMPUSNEWS + "_"
					+ campusnews.getCampusnewId());
			break;
		case IndexUtil.OP_UPDATE:
			IndexField field2 = IndexUtil.createIndexField(
					campusnews.getCampusnewId(),
					(campusnews.getNewstype() == 1) ? "新闻" : "通知",
					campusnews.getContent(), IndexUtil.ACTION_CAMPUSNEWS);
			updateIndex(field2);
			break;
		}
	}

	private void indexUser(User user, int operator) {
		switch (operator) {
		case IndexUtil.OP_ADD:
			IndexField field1 = IndexUtil.createIndexField(user.getUserId(),
					user.getUsername(), user.getDescription(),
					IndexUtil.ACTION_USER);
			addIndex(field1);
			break;
		case IndexUtil.OP_DEL:
			deleteIndex(IndexUtil.ACTION_USER + "_" + user.getUserId());
			break;
		case IndexUtil.OP_UPDATE:
			IndexField field2 = IndexUtil.createIndexField(user.getUserId(),
					user.getUsername(), user.getDescription(),
					IndexUtil.ACTION_USER);
			updateIndex(field2);
			break;
		}
	}

	private void indexScenicspot(Scenicspot scenicspot, int operator) {
		switch (operator) {
		case IndexUtil.OP_ADD:
			IndexField field1 = IndexUtil.createIndexField(
					scenicspot.getScenicspotId(), scenicspot.getSpotname(),
					scenicspot.getDescription(), IndexUtil.ACTION_SCENICSPOT);
			addIndex(field1);
			break;
		case IndexUtil.OP_DEL:
			deleteIndex(IndexUtil.ACTION_SCENICSPOT + "_"
					+ scenicspot.getScenicspotId());
			break;
		case IndexUtil.OP_UPDATE:
			IndexField field2 = IndexUtil.createIndexField(
					scenicspot.getScenicspotId(), scenicspot.getSpotname(),
					scenicspot.getDescription(), IndexUtil.ACTION_SCENICSPOT);
			updateIndex(field2);
			break;
		}
	}

	// @Override
	// public PageObject<Index> findByIndex(String condition) {
	// if(condition==null) condition = "";
	// PageObject<Index> pages = new PageObject<Index>();
	// List<Index> datas = new ArrayList<Index>();
	// try {
	// int pageSize = SystemContext.getPageSize();
	// int pageOffset = SystemContext.getPageOffset();
	// SolrQuery query = new SolrQuery(condition);
	// query.setHighlight(true)
	// .setHighlightSimplePre("<span class='lighter'>")
	// .setHighlightSimplePost("</span>")
	// .setParam("hl.fl", "msg_title,msg_content")
	// .setStart(pageOffset).setRows(pageSize);
	// QueryResponse resp = SolrContext.getServer().query(query);
	// SolrDocumentList sdl = resp.getResults();
	// for(SolrDocument sd:sdl) {
	// String id = (String)sd.getFieldValue("id");
	// int msgId = (Integer)sd.getFieldValue("msg_id");
	// String title = (String)sd.getFieldValue("msg_title");
	// Date date = (Date)sd.getFieldValue("msg_date");
	// List<String> contents = (List)sd.getFieldValues("msg_content");
	// StringBuffer sb = new StringBuffer();
	// for(String con:contents) {
	// sb.append(con);
	// }
	// System.out.println(sb.toString());
	// String sc = sb.toString();
	// Index index = new Index();
	// index.setCreateDate(date);
	// index.setTitle(title);
	//
	// if(sc.length()>=150) {
	// sc = sc.substring(0,150);
	// }
	// index.setSummary(sc);
	// index.setMsgId(msgId);
	// if(resp.getHighlighting().get(id)!=null) {
	// List<String> htitle = resp.getHighlighting().get(id).get("msg_title");
	// if(htitle!=null) index.setTitle(htitle.get(0));
	// List<String> hcontent =
	// resp.getHighlighting().get(id).get("msg_content");
	// if(hcontent!=null)index.setSummary(hcontent.get(0));
	// }
	// datas.add(index);
	// }
	//
	// pages.setDatas(datas);
	// pages.setOffset(pageOffset);
	// pages.setPageSize(pageSize);
	// pages.setTotalRecord(new Long(sdl.getNumFound()).intValue());
	// } catch (SolrServerException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return pages;
	// }
}
