package com.techthinker.CAWeb.util;

import java.io.IOException;
import java.io.StringWriter;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * JSON数据工具类
 * @author JC@Techthinker.com
 *
 */
public class JsonJacksonUtil {
	private final static JsonJacksonUtil util = new JsonJacksonUtil();
	private final static JsonFactory factory = new JsonFactory();
	
	public static JsonJacksonUtil getInstance() {
		return util;
	}
	
	/**
	 * 将对象转化成JSON数据
	 * @param obj 需要转化的对象
	 * @return JSON数据
	 */
	public String obj2json(Object obj) {
		//通过jsonFactory创建JsonGenerator,要传入相应的输出流
		StringWriter out = new StringWriter();
		JsonGenerator jg = null;
		try {
			jg = factory.createJsonGenerator(out);
			//创建对象mapper
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(jg, obj);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				if(jg!=null) jg.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return out.getBuffer().toString();
	}
	
	/**
	 * 将JSON转化成对应的对象
	 * @param json JSON数据
	 * @param clazz 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object json2obj(String json,Class clazz) {
		ObjectMapper mapper = new ObjectMapper();
		Object o = null;
		try {
			o = mapper.readValue(json, clazz);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return o;
	}
}
