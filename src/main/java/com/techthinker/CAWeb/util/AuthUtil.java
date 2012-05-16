package com.techthinker.CAWeb.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 权限管理工具类
 * @author JC@Techthinker.com
 *
 */
public class AuthUtil {
	
	/**
	 * 对请求的path进行权限验证
	 * @param roleId 角色的id
	 * @param auths 全局权限配置信息
	 * @param path 所请求访问的路径
	 * @return 是否有权限访问
	 */
	public static boolean checkAuth(int roleId,Map<Integer,List<String>> auths,String path) {
		//1、获取List资源
		List<String> reses = auths.get(roleId);
		//2、变量整个list，比较path是否匹配：正则表达式
		Pattern pattern = null;
		for(String resReg:reses) {
			resReg = resReg.replace("*", ".*");
			resReg=resReg.trim();
			pattern = Pattern.compile(resReg);
			//若匹配这说明有相应的浏览权限
			if(pattern.matcher(path).matches()) return true;
		}
		return false;
	}
	/**
	 * 读取auth.xml中的配置信息，转换成map
	 * @return map，由id及其对应可访问的页面名称组成
	 */
	@SuppressWarnings("unchecked")
	public static Map<Integer,List<String>> initAuth() {
		SAXReader reader = new SAXReader();
		Map<Integer,List<String>> auths = new HashMap<Integer, List<String>>();
		try {
			Document d = reader.read(AuthUtil.class.getClassLoader().getResourceAsStream("auth.xml"));
			Element ele = d.getRootElement();
			//获取到所有的role节点
			List<Element> eles = ele.selectNodes("role");
			//遍历所有的role节点，并且将角色于资源的对应关系存储到一个map中
			List<String> reses = null;
			for(Element e:eles) {
				//将数据存储到一个map中
				reses = new ArrayList<String>();
				int roleId = Integer.parseInt(e.attributeValue("id"));
				auths.put(roleId, reses);
				addToRes(reses,e);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}finally {
			reader.resetHandlers();
			reader = null;
		}
		return auths;
	}
	
	/**
	 * 递归解析节点元素下的信息
	 * @param reses	用于存储可访问的页面名称
	 * @param e 被解析的节点元素
	 */
	private static void addToRes(List<String> reses, Element e) {
		/**
		 * 判断include，根据include的值来处理include中的元素
		 */
		Element includeEle = (Element)e.selectSingleNode("include");
		if(includeEle!=null) {
			//如果存在include节点，需要把name为include中的值的这个节点说访问的资源存储
			//1、根据include的text获取这个name为这个text的节点
			Element includeResEle = (Element)e.selectSingleNode("/auth/role[name='"+includeEle.getTextTrim()+"']");
			//2、将这个节点的值添加到list的reses中
			addToRes(reses,includeResEle);
		}
		//获取resoucres节点
		Element rele = (Element)e.selectSingleNode("resources");
		//获取节点中的值，也就是可以访问的字符串
		String resStr = rele.getTextTrim();
		//将字符串转换为字符串数组
		String[] resStrs = resStr.split(",");
		//asList可以将字符串数组转换为list,addAll方法可以为list直接添加list
		reses.addAll(Arrays.asList(resStrs));
	}
}
