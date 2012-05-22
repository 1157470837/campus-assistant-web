package com.techthinker.CAWeb.util;

import com.techthinker.CAWeb.vo.IndexField;


public class IndexUtil {
	public static final String ACTION_USER = "User";
	public static final String ACTION_COLLEGE = "College";
	public static final String ACTION_MAJOR = "Major";
	public static final String ACTION_GRADE = "grade";
	public static final String ACTION_CAMPUSNEWS = "campusnews";
	public static final String ACTION_QUESTION = "question";
	public static final String ACTION_SCENICSPOT = "scenicspot";
	public static final String ACTION_INTENT = "intent";
	
	public final static int OP_ADD= 1;
	public final static int OP_DEL= 2;
	public final static int OP_UPDATE = 3;
	
	public static IndexField createIndexField(int subjectId,String title,String content,String action) {
		IndexField field = new IndexField();
		field.setId(action+"_"+subjectId);
		field.setSubjectId(subjectId);
		field.setTitle(title);
		field.setContent(content);
		field.setAction(action);
		return field;
	}

}
