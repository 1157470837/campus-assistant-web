package com.techthinker.CAWeb.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="intent", catalog = "campusassistant_web")
public class Intent implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2415753406160333553L;
	private Integer intent_id;
	private String brief;
	private String extension;
	private String intention;
	private Boolean availabe;
	/**
	 * @return the intent_id
	 */
	@Id
	@GeneratedValue
	public Integer getIntent_id() {
		return intent_id;
	}
	/**
	 * @param intent_id the intent_id to set
	 */
	public void setIntent_id(Integer intent_id) {
		this.intent_id = intent_id;
	}
	/**
	 * @return the brief
	 */
	@Column(name="brief")
	public String getBrief() {
		return brief;
	}
	/**
	 * @param brief the brief to set
	 */
	public void setBrief(String brief) {
		this.brief = brief;
	}
	/**
	 * @return the extension
	 */
	@Column(name="extension")
	public String getExtension() {
		return extension;
	}
	/**
	 * @param extension the extension to set
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}
	/**
	 * @return the intention
	 */
	@Column(name="intention")
	public String getIntention() {
		return intention;
	}
	/**
	 * @param intention the intention to set
	 */
	public void setIntention(String intention) {
		this.intention = intention;
	}
	/**
	 * @return the availabe
	 */
	@Column(name="availabe")
	public Boolean getAvailabe() {
		return availabe;
	}
	/**
	 * @param availabe the availabe to set
	 */
	public void setAvailabe(Boolean availabe) {
		this.availabe = availabe;
	}

}
