package com.techthinker.CAWeb.iservice;

import java.io.IOException;
import java.io.InputStream;

public interface IIntentService {
	/**
	 * 从输入流中批量读取intent信息，并插入数据库
	 * 
	 * @param inputStream
	 *            输入流
	 * @throws IOException
	 *             IO异常
	 */
	public void addIntentsFromInputStream(InputStream inputStream)
			throws IOException;
}
