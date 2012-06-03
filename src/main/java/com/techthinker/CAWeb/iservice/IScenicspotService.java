package com.techthinker.CAWeb.iservice;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.techthinker.CAWeb.persistence.Scenicspot;

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
	
	/**
	 * 获取所有景点列表
	 * @return 所有校园消息列表
	 */
	public List<Scenicspot> listDormitories();
	/**
	 * 加载宿舍
	 * @param name
	 * @return
	 */
	public Scenicspot loadDormByName(String name);
	/**
	 * 根据Id加载S侧昵称spot对象
	 * @param id
	 * @return
	 */
	public Scenicspot load(int id);
	
}
