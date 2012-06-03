package com.techthinker.CAWeb.etart;

import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import com.techthinker.CAWeb.persistence.IndexField;
import com.techthinker.CAWeb.solr.SolrContext;
import com.techthinker.CAWeb.util.SystemConstant;

public class EtartSolrQuery {
	public static List<KeyWord> intentMapping(List<KeyWord> keyWords) {
		String condition = null;
		for (KeyWord key : keyWords) {
			condition=SystemConstant.QUERY_FIELD + ":" + key.getKey()
					+ "NOT index_action:Question";
			IndexField indexField = QueryKey(condition);
			key.setIndexField(indexField);
		}
		return keyWords;
	}
	
	private static IndexField QueryFAQ(String faQuestion){
		String condition=SystemConstant.QUERY_FIELD + ":" + faQuestion
				+ "AND index_action:Question";
		IndexField indexField = QueryKey(condition);
		return indexField;
	}

	private static IndexField QueryKey(String condition) {
		if (condition == null)
			condition = "";
		IndexField indexField = new IndexField();
		try {
			SolrQuery query = new SolrQuery();
			query.setQuery(condition);
			QueryResponse resp = SolrContext.getServer().query(query);
			SolrDocumentList sdl = resp.getResults();
			if (sdl.size() > 0) {
				SolrDocument sd = sdl.get(0);
				String id = (String) sd.getFieldValue("id");
				int subjectId = (Integer) sd.getFieldValue("index_subjectid");
				String title = (String) sd.getFieldValue("index_title");
				String content = (String) sd.getFieldValue("index_content");
				String action = (String) sd.getFieldValue("index_action");
				indexField.setAction(action);
				indexField.setContent(content);
				indexField.setId(id);
				indexField.setSubjectId(subjectId);
				indexField.setTitle(title);
			}
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		return indexField;
	}
}
