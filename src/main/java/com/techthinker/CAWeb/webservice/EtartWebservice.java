package com.techthinker.CAWeb.webservice;

import java.util.List;

import org.springframework.stereotype.Component;

import com.techthinker.CAWeb.etart.EtartSolrQuery;
import com.techthinker.CAWeb.etart.EtartTokenizer;
import com.techthinker.CAWeb.etart.KeyWord;
import com.techthinker.CAWeb.iwebservice.IEtartWebservice;
import com.techthinker.CAWeb.model.UserModel;

@Component("etartWebservice")
public class EtartWebservice implements IEtartWebservice{

	@Override
	public UserModel[] recommendFriends(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String etartChat(String chatContent) {
		List<KeyWord> keyWords=EtartTokenizer.Analyze("蒋超是信息学院哪个专业的？");
		String result=EtartSolrQuery.intentMapping(keyWords).toString();
		return result;
	}

}
