package com.techthinker.CAWeb.etart;

import com.techthinker.CAWeb.persistence.IndexField;

public class KeyWord {
	public String key;
	public IndexField indexField;
	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * @return the indexField
	 */
	public IndexField getIndexField() {
		return indexField;
	}
	/**
	 * @param indexField the indexField to set
	 */
	public void setIndexField(IndexField indexField) {
		this.indexField = indexField;
	}
	@Override
	public String toString() {
		return "KeyWord [key=" + key + ", indexField=" + indexField + "]";
	}
}
