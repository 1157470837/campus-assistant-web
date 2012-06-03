package com.techthinker.CAWeb.util;

import com.techthinker.CAWeb.persistence.IndexField;


public class IndexUtil {
	public static final String ACTION_USER = "User";
	public static final String ACTION_COLLEGE = "College";
	public static final String ACTION_MAJOR = "Major";
	public static final String ACTION_GRADE = "Grade";
	public static final String ACTION_CAMPUSNEWS = "Campusnews";
	public static final String ACTION_QUESTION = "Question";
	public static final String ACTION_SCENICSPOT = "Scenicspot";
	public static final String ACTION_INTENT = "Intent";
	
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
