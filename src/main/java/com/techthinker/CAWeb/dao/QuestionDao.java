package com.techthinker.CAWeb.dao;

import org.springframework.stereotype.Repository;

import com.techthinker.CAWeb.idao.IQuestionDao;
import com.techthinker.CAWeb.persistence.Question;

@Repository("questionDao")
public class QuestionDao extends BaseDao<Question> implements IQuestionDao {

}
