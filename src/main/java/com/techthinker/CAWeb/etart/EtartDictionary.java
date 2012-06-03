package com.techthinker.CAWeb.etart;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wltea.analyzer.cfg.Configuration;
import org.wltea.analyzer.cfg.DefualtConfig;
import org.wltea.analyzer.dic.Dictionary;

import com.techthinker.CAWeb.idao.IUserDao;
import com.techthinker.CAWeb.util.SystemConstant;

@Service("etartService")
public class EtartDictionary {
	public static Configuration defualtConfig = DefualtConfig.getInstance();
	private static Dictionary dic;
	private static List<String> extDics;
	private IUserDao userDao;
	static {
		defualtConfig.setUseSmart(SystemConstant.IKSMART);
		extDics = defualtConfig.getExtDictionarys();
		dic = Dictionary.initial(defualtConfig);
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	@Resource
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * 将新注册的用户名更新username词典，并把其加到内存字典中
	 * 
	 * @param usersnames
	 *            新注册添加的用户名
	 */
	public void updateUserDic(List<String> usersnames) {
		String extPath = null;
		for (String ext : extDics) {
			if (ext.contains("username")) {
				extPath = SystemConstant.CLASSPATH + ext;
				updateDic(extPath, usersnames);
			}
		}
	}

	/**
	 * 将新添加的学院名更新collegename词典，并把其加到内存字典中
	 * 
	 * @param collegesNames
	 *            新添加的学院名
	 */
	public void updateCollegeDic(List<String> collegesNames) {
		String extPath = null;
		for (String ext : extDics) {
			if (ext.contains("collegename")) {
				extPath = SystemConstant.CLASSPATH + ext;
				updateDic(extPath, collegesNames);
			}
		}
	}

	/**
	 * 将新添加的专业名更新majorname词典，并把其加到内存字典中
	 * 
	 * @param majorsNames
	 *            新添加的专业名
	 */
	public void updateMajorDic(List<String> majorsNames) {
		String extPath = null;
		for (String ext : extDics) {
			if (ext.contains("majorname")) {
				extPath = SystemConstant.CLASSPATH + ext;
				updateDic(extPath, majorsNames);
			}
		}
	}

	/**
	 * 将新添加的景点名更新spotname词典，并把其加到内存字典中
	 * 
	 * @param scenicspotsNames
	 *            新添加的景点名
	 */
	public void updateScenicspotDic(List<String> scenicspotsNames) {
		String extPath = null;
		for (String ext : extDics) {
			if (ext.contains("spotname")) {
				extPath = SystemConstant.CLASSPATH + ext;
				updateDic(extPath, scenicspotsNames);
			}
		}
	}

	/**
	 * 将新添加的意图名更新intent词典，并把其加到内存字典中
	 * 
	 * @param scenicspotsNames
	 *            新添加的意图名
	 */
	public void updateIntentDic(List<String> intents) {
		String extPath = null;
		for (String ext : extDics) {
			if (ext.contains("intent")) {
				extPath = SystemConstant.CLASSPATH + ext;
				updateDic(extPath, intents);
			}
		}
	}

	/**
	 * 将文本添加到磁盘指定路径下的文件中
	 * 
	 * @param extPath
	 *            文件的磁盘路径
	 * @param names
	 *            要添加的内容
	 */
	public void updateDic(String extPath, List<String> names) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(extPath, true), "UTF-8"));
			List<String> usernames = new ArrayList<String>();
			for (String s : names) {
				usernames.add(s);
				writer.write(s);
				writer.newLine();
			}
			dic.addWords(names);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
