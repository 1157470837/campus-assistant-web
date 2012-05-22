package com.techthinker.CAWeb.iservice;

import java.io.IOException;
import java.io.InputStream;

import com.techthinker.CAWeb.vo.Scenicspot;

public interface IScenicspotService {
	/**
	 * 从输入流中批量读取scenicspot信息及其geoinfo，并插入数据库
	 * @param inputStream 输入流
	 * @throws IOException IO异常
	 */
	public void addScenicspotsFromInputStream(InputStream inputStream)throws IOException;
	/**
	 * 判断数据库中是否有scenicspotId
	 * @param scenicspotId 要判断的scenicspotId
	 * @return 如果存在，则返回此Scenicspot对象
	 */
	public Scenicspot checkScenicspotsIdExists(int scenicspotId);
}
