package com.techthinker.CAWeb.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.stereotype.Service;

import com.techthinker.CAWeb.analyzer.EtartAnalyzer;
import com.techthinker.CAWeb.idao.ICampusnewsDao;
import com.techthinker.CAWeb.idao.ICollegeDao;
import com.techthinker.CAWeb.idao.IGradeDao;
import com.techthinker.CAWeb.idao.IIntentDao;
import com.techthinker.CAWeb.idao.IMajorDao;
import com.techthinker.CAWeb.idao.IQuestionDao;
import com.techthinker.CAWeb.idao.IScenicspotDao;
import com.techthinker.CAWeb.idao.ITempIndexDao;
import com.techthinker.CAWeb.idao.IUserDao;
import com.techthinker.CAWeb.iservice.IIndexService;
import com.techthinker.CAWeb.solr.SolrContext;
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
	private EtartAnalyzer etart;

	/**
	 * @return the etart
	 */
	public EtartAnalyzer getEtart() {
		return etart;
	}

	/**
	 * @param etart
	 *            the etart to set
	 */
	@Resource
	public void setEtart(EtartAnalyzer etart) {
		this.etart = etart;
	}

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
	public void updateIndex(IndexField field) {
		try {
			SolrContext.getServer().deleteById(field.getId());
			SolrContext.getServer().addBean(field);
			SolrContext.getServer().commit();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addIndex(List<IndexField> fields) {
		try {
			SolrContext.getServer().addBeans(fields);
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
			if(tis.size()<=0) return;
			List<IndexField> indexFields = new ArrayList<IndexField>();
			List<IndexField> userIndexFields = new ArrayList<IndexField>();
			List<IndexField> campusnewsIndexFields = new ArrayList<IndexField>();
			List<IndexField> collegeIndexFields = new ArrayList<IndexField>();
			List<IndexField> gradeIndexFields = new ArrayList<IndexField>();
			List<IndexField> intentIndexFields = new ArrayList<IndexField>();
			List<IndexField> majorIndexFields = new ArrayList<IndexField>();
			List<IndexField> questionIndexFields = new ArrayList<IndexField>();
			List<IndexField> senicspotIndexFields = new ArrayList<IndexField>();
			List<User> users = new ArrayList<User>();
			for (TempIndex ti : tis) {
				if (ti.getObjType().equals(IndexUtil.ACTION_USER)) {
					User user = userDao.load(ti.getObjId());
					users.add(user);
					userIndexFields.add(indexUser(user, ti.getOperator()));
				} else if (ti.getObjType().equals(IndexUtil.ACTION_CAMPUSNEWS)) {
					Campusnews campusnews = campusnewsDao.load(ti.getObjId());
					campusnewsIndexFields.add(indexCampusnews(campusnews,
							ti.getOperator()));
				} else if (ti.getObjType().equals(IndexUtil.ACTION_COLLEGE)) {
					College college = collegeDao.load(ti.getObjId());
					collegeIndexFields.add(indexCollege(college,
							ti.getOperator()));
				} else if (ti.getObjType().equals(IndexUtil.ACTION_GRADE)) {
					Grade grade = gradeDao.load(ti.getObjId());
					gradeIndexFields.add(indexGrade(grade, ti.getOperator()));
				} else if (ti.getObjType().equals(IndexUtil.ACTION_INTENT)) {
					Intent intent = intentDao.load(ti.getObjId());
					intentIndexFields
							.add(indexIntent(intent, ti.getOperator()));
				} else if (ti.getObjType().equals(IndexUtil.ACTION_MAJOR)) {
					Major major = majorDao.load(ti.getObjId());
					majorIndexFields.add(indexMajor(major, ti.getOperator()));
				} else if (ti.getObjType().equals(IndexUtil.ACTION_QUESTION)) {
					Question question = questionDao.load(ti.getObjId());
					questionIndexFields.add(indexQuestion(question,
							ti.getOperator()));
				} else if (ti.getObjType().equals(IndexUtil.ACTION_SCENICSPOT)) {
					Scenicspot scenicspot = scenicspotDao.load(ti.getObjId());
					senicspotIndexFields.add(indexScenicspot(scenicspot,
							ti.getOperator()));
				}
			}
			etart.updateUserDic(users);
			indexFields.addAll(userIndexFields);
			indexFields.addAll(collegeIndexFields);
			indexFields.addAll(majorIndexFields);
			indexFields.addAll(gradeIndexFields);
			indexFields.addAll(questionIndexFields);
			indexFields.addAll(senicspotIndexFields);
			indexFields.addAll(campusnewsIndexFields);
			indexFields.addAll(indexFields);
			addIndex(indexFields);
			SolrContext.getServer().commit();
			tempIndexDao.delAll();
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateReconstructorIndex() {
		/**
		 * 将数据库中的所有对象取出，创建相应的IndexField完成索引的重构
		 */
		try {
			SolrContext.getServer().deleteByQuery("*:*");
			List<IndexField> indexFields;
			List<User> users = userDao.list("from User");
			indexFields = indexUsers(users, IndexUtil.OP_ADD);
			List<College> colleges = collegeDao.list("from College");
			indexFields.addAll(indexCollege(colleges, IndexUtil.OP_ADD));
			List<Major> majors = majorDao.list("from Major");
			indexFields.addAll(indexMajors(majors, IndexUtil.OP_ADD));
			List<Grade> grades = gradeDao.list("from Grade");
			indexFields.addAll(indexGrades(grades, IndexUtil.OP_ADD));
			List<Campusnews> campusnewses = campusnewsDao
					.list("from Campusnews");
			indexFields
					.addAll(indexCampusnewses(campusnewses, IndexUtil.OP_ADD));
			List<Question> questions = questionDao.list("from Question");
			indexFields.addAll(indexQuestions(questions, IndexUtil.OP_ADD));
			List<Intent> intents = intentDao.list("from Intent");
			indexFields.addAll(indexIntents(intents, IndexUtil.OP_ADD));
			List<Scenicspot> scenicspots = scenicspotDao
					.list("from Scenicspot");
			indexFields.addAll(indexScenicspots(scenicspots, IndexUtil.OP_ADD));
			addIndex(indexFields);
			SolrContext.getServer().commit();
			tempIndexDao.delAll();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
	}

	private List<IndexField> indexUsers(List<User> users, int operator) {
		List<IndexField> indexFields = new ArrayList<IndexField>();
		for (User user : users) {
			indexFields.add(indexUser(user, operator));
		}
		return indexFields;
	}

	private List<IndexField> indexCollege(List<College> colleges, int operator) {
		List<IndexField> indexFields = new ArrayList<IndexField>();
		for (College college : colleges) {
			indexFields.add(indexCollege(college, operator));
		}
		return indexFields;
	}

	private List<IndexField> indexMajors(List<Major> majors, int operator) {
		List<IndexField> indexFields = new ArrayList<IndexField>();
		for (Major major : majors) {
			indexFields.add(indexMajor(major, operator));
		}
		return indexFields;
	}

	private List<IndexField> indexGrades(List<Grade> grades, int operator) {
		List<IndexField> indexFields = new ArrayList<IndexField>();
		for (Grade grade : grades) {
			indexFields.add(indexGrade(grade, operator));
		}
		return indexFields;
	}

	private List<IndexField> indexCampusnewses(List<Campusnews> campusnewses,
			int operator) {
		List<IndexField> indexFields = new ArrayList<IndexField>();
		for (Campusnews campusnewse : campusnewses) {
			indexFields.add(indexCampusnews(campusnewse, operator));
		}
		return indexFields;
	}

	private List<IndexField> indexQuestions(List<Question> questions,
			int operator) {
		List<IndexField> indexFields = new ArrayList<IndexField>();
		for (Question question : questions) {
			indexFields.add(indexQuestion(question, operator));
		}
		return indexFields;
	}

	private List<IndexField> indexIntents(List<Intent> intents, int operator) {
		List<IndexField> indexFields = new ArrayList<IndexField>();
		for (Intent intent : intents) {
			indexFields.add(indexIntent(intent, operator));
		}
		return indexFields;
	}

	private List<IndexField> indexScenicspots(List<Scenicspot> scenicspots,
			int operator) {
		List<IndexField> indexFields = new ArrayList<IndexField>();
		for (Scenicspot scenicspot : scenicspots) {
			indexFields.add(indexScenicspot(scenicspot, operator));
		}
		return indexFields;
	}

	private IndexField indexQuestion(Question question, int operator) {
		IndexField indexField = null;
		switch (operator) {
		case IndexUtil.OP_ADD:
			indexField = IndexUtil.createIndexField(question.getQuestionId(),
					question.getContent(), question.getAnswer(),
					IndexUtil.ACTION_QUESTION);
			break;
		case IndexUtil.OP_DEL:
			deleteIndex(IndexUtil.ACTION_QUESTION + "_"
					+ question.getQuestionId());
			break;
		case IndexUtil.OP_UPDATE:
			indexField = IndexUtil.createIndexField(question.getQuestionId(),
					question.getContent(), question.getAnswer(),
					IndexUtil.ACTION_QUESTION);
			break;
		}
		return indexField;
	}

	private IndexField indexMajor(Major major, int operator) {
		IndexField indexField = null;
		switch (operator) {
		case IndexUtil.OP_ADD:
			indexField = IndexUtil.createIndexField(major.getMajorId(),
					major.getMajorName(), major.getDescription(),
					IndexUtil.ACTION_MAJOR);

			break;
		case IndexUtil.OP_DEL:
			deleteIndex(IndexUtil.ACTION_MAJOR + "_" + major.getMajorId());
			break;
		case IndexUtil.OP_UPDATE:
			indexField = IndexUtil.createIndexField(major.getMajorId(),
					major.getMajorName(), major.getDescription(),
					IndexUtil.ACTION_MAJOR);

			break;
		}
		return indexField;
	}

	private IndexField indexIntent(Intent intent, int operator) {
		IndexField indexField = null;
		switch (operator) {
		case IndexUtil.OP_ADD:
			indexField = IndexUtil.createIndexField(intent.getIntent_id(),
					intent.getBrief(), intent.getExtension(),
					IndexUtil.ACTION_INTENT);

			break;
		case IndexUtil.OP_DEL:
			deleteIndex(IndexUtil.ACTION_INTENT + "_" + intent.getIntent_id());
			break;
		case IndexUtil.OP_UPDATE:
			indexField = IndexUtil.createIndexField(intent.getIntent_id(),
					intent.getBrief(), intent.getExtension(),
					IndexUtil.ACTION_INTENT);

			break;
		}
		return indexField;
	}

	private IndexField indexGrade(Grade grade, int operator) {
		IndexField indexField = null;
		switch (operator) {
		case IndexUtil.OP_ADD:
			indexField = IndexUtil.createIndexField(grade.getGradeId(),
					grade.getGradeName(), grade.getDescription(),
					IndexUtil.ACTION_GRADE);

			break;
		case IndexUtil.OP_DEL:
			deleteIndex(IndexUtil.ACTION_GRADE + "_" + grade.getGradeId());
			break;
		case IndexUtil.OP_UPDATE:
			indexField = IndexUtil.createIndexField(grade.getGradeId(),
					grade.getGradeName(), grade.getDescription(),
					IndexUtil.ACTION_GRADE);
			break;
		}
		return indexField;
	}

	private IndexField indexCollege(College college, int operator) {
		IndexField indexField = null;
		switch (operator) {
		case IndexUtil.OP_ADD:
			indexField = IndexUtil.createIndexField(college.getCollegeId(),
					college.getCollegeName(), college.getDescription(),
					IndexUtil.ACTION_COLLEGE);
			break;
		case IndexUtil.OP_DEL:
			deleteIndex(IndexUtil.ACTION_COLLEGE + "_" + college.getCollegeId());
			break;
		case IndexUtil.OP_UPDATE:
			indexField = IndexUtil.createIndexField(college.getCollegeId(),
					college.getCollegeName(), college.getDescription(),
					IndexUtil.ACTION_COLLEGE);
			break;
		}
		return indexField;
	}

	private IndexField indexCampusnews(Campusnews campusnews, int operator) {
		IndexField indexField = null;
		switch (operator) {
		case IndexUtil.OP_ADD:
			indexField = IndexUtil.createIndexField(
					campusnews.getCampusnewId(),
					(campusnews.getNewstype() == 1) ? "新闻" : "通知",
					campusnews.getContent(), IndexUtil.ACTION_CAMPUSNEWS);
			break;
		case IndexUtil.OP_DEL:
			deleteIndex(IndexUtil.ACTION_CAMPUSNEWS + "_"
					+ campusnews.getCampusnewId());
			break;
		case IndexUtil.OP_UPDATE:
			indexField = IndexUtil.createIndexField(
					campusnews.getCampusnewId(),
					(campusnews.getNewstype() == 1) ? "新闻" : "通知",
					campusnews.getContent(), IndexUtil.ACTION_CAMPUSNEWS);
			break;
		}
		return indexField;
	}

	private IndexField indexUser(User user, int operator) {
		IndexField indexField = null;
		switch (operator) {
		case IndexUtil.OP_ADD:
			indexField = IndexUtil.createIndexField(user.getUserId(),
					user.getUsername(), user.getDescription(),
					IndexUtil.ACTION_USER);
			break;
		case IndexUtil.OP_DEL:
			deleteIndex(IndexUtil.ACTION_USER + "_" + user.getUserId());
			break;
		case IndexUtil.OP_UPDATE:
			indexField = IndexUtil.createIndexField(user.getUserId(),
					user.getUsername(), user.getDescription(),
					IndexUtil.ACTION_USER);
			break;
		}
		return indexField;
	}

	private IndexField indexScenicspot(Scenicspot scenicspot, int operator) {
		IndexField indexField = null;
		switch (operator) {
		case IndexUtil.OP_ADD:
			indexField = IndexUtil.createIndexField(
					scenicspot.getScenicspotId(), scenicspot.getSpotname(),
					scenicspot.getDescription(), IndexUtil.ACTION_SCENICSPOT);
			break;
		case IndexUtil.OP_DEL:
			deleteIndex(IndexUtil.ACTION_SCENICSPOT + "_"
					+ scenicspot.getScenicspotId());
			break;
		case IndexUtil.OP_UPDATE:
			indexField = IndexUtil.createIndexField(
					scenicspot.getScenicspotId(), scenicspot.getSpotname(),
					scenicspot.getDescription(), IndexUtil.ACTION_SCENICSPOT);
			break;
		}
		return indexField;
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
