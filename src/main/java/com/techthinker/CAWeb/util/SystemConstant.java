package com.techthinker.CAWeb.util;

import java.io.File;

public class SystemConstant {
	//分词方式
	public static final boolean IKSMART = true;
	//solr查询字段
	public static final String QUERY_FIELD = "index_query";
	
	public static String SCENICSPOT_IMAGE_FOULDER="scenicspotImages/";
	public static String CLASSPATH = SystemContext.getRealPath() + File.separator+"WEB-INF"+File.separator+"classes"+File.separator;
}
