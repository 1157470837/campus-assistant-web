package com.techthinker.CAWeb.etart;

import java.util.List;
import java.util.Map;

public class EtartIntentionDispatcher {
	public static String dispatch(String requestContent) {
		List<KeyWord> keyWords = EtartTokenizer.Analyze(requestContent);
		keyWords = EtartSolrQuery.intentMapping(keyWords);
		Map<String, List<KeyWord>> rawIntention =EtartIntentAnalyzer.figureIntention(keyWords);
		
		return null;
	}
}
