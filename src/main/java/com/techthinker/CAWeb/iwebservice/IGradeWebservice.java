package com.techthinker.CAWeb.iwebservice;

import javax.jws.WebParam;
import javax.jws.WebResult;

import com.techthinker.CAWeb.model.GradeModel;
/**
 * 聊天室模块的Web Service
 * @author JC@Techthinker.com
 *
 */
public interface IGradeWebservice {
	/**
	 * 同步年级信息，将所有年级信息取出，并采取按页请求，当返回为空是说明没有数据了</br>
	 * 每页数据的数量由SystemContext指定
	 * @param pageNum 请求的页数
	 * @return 年级信息
	 */
	@WebResult(name = "syncGradeReturn")
	public GradeModel[] syncGrade(@WebParam(name = "pageNum")int pageNum);
	
}
