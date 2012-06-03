package com.techthinker.CAWeb.iwebservice;

import javax.jws.WebParam;
import javax.jws.WebResult;

import com.techthinker.CAWeb.model.GeoinfoModel;
/**
 * 聊天室模块的Web Service
 * @author JC@Techthinker.com
 *
 */
public interface IGeoinfoWebservice {
	/**
	 * 同步地理位置信息，将所有地理位置信息取出，并采取按页请求，当返回为空是说明没有数据了</br>
	 * 每页数据的数量由SystemContext指定
	 * @param pageNum 请求的页数
	 * @return 地理位置信息
	 */
	@WebResult(name = "syncGeoinfoReturn")
	public GeoinfoModel[] syncGeoinfo(@WebParam(name = "pageNum")int pageNum);
	
}
