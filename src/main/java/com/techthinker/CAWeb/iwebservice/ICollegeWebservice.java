package com.techthinker.CAWeb.iwebservice;

import javax.jws.WebParam;
import javax.jws.WebResult;

import com.techthinker.CAWeb.model.CollegeModel;
/**
 * College模块的Web Service
 * @author JC@Techthinker.com
 *
 */
public interface ICollegeWebservice {
	/**
	 * 同步College信息，将所有College信息取出，并采取按页请求,当返回为空是说明没有数据了</br>
	 * 每页数据的数量由SystemContext指定
	 * @param pageNum 请求的页数
	 * @return College信息
	 */
	@WebResult(name = "syncCollegeReturn")
	public CollegeModel[] syncCollege(@WebParam(name = "pageNum")int pageNum);
	
}
