package com.techthinker.CAWeb.service;

import org.springframework.stereotype.Service;

import com.techthinker.CAWeb.iservice.IIndexService;
import com.techthinker.CAWeb.util.PageObject;
import com.techthinker.CAWeb.vo.Index;
import com.techthinker.CAWeb.vo.IndexField;

@Service("indexService")
public class IndexService implements IIndexService {

	@Override
	public void addIndex(IndexField fields, boolean inDatabase) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteIndex(String id, String type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateIndex(IndexField fields) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PageObject<Index> findByIndex(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCommitIndex() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateReconstructorIndex() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSetIndex() {
		// TODO Auto-generated method stub
		
	}

}
