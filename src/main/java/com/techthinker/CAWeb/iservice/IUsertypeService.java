package com.techthinker.CAWeb.iservice;

import java.io.IOException;
import java.io.InputStream;

import com.techthinker.CAWeb.persistence.Usertype;

public interface IUsertypeService {
	/**
	 * 从输入流中批量读取Usertype信息，并插入数据库
	 * @param inputStream 输入流
	 * @throws IOException IO异常
	 */
	public void addUsertypeFromInputStream(InputStream inputStream)throws IOException;
	/**
	 * 根据Id获取一个Usertype对象
	 * @param id Usertype的id号
	 * @return
	 */
	public Usertype loadByUsertypeId(int id );
}
