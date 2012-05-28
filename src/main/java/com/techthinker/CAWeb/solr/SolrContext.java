package com.techthinker.CAWeb.solr;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;

public class SolrContext {
	private final static String URL = "http://localhost:8080/solr";

	private static HttpSolrServer server = null;
	static {
		server = new HttpSolrServer(URL);
	}
	public static SolrServer getServer() {
		return server;
	}

}
