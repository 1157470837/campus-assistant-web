package com.techthinker.CAWeb.vo;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Campusnews entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "campusnews", catalog = "campusassistant_web")
public class Campusnews implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6742786879679315019L;
	private Integer campusnewId;
	private User user;
	private College college;
	private Major major;
	private Integer newstype;
	private String content;
	private Timestamp pubdate;
	private Integer level;

	// Constructors

	/** default constructor */
	public Campusnews() {
	}

	/** full constructor */
	public Campusnews(User user, College college, Major major,
			Integer newstype, String content, Timestamp pubdate, Integer level) {
		this.user = user;
		this.college = college;
		this.major = major;
		this.newstype = newstype;
		this.content = content;
		this.pubdate = pubdate;
		this.level = level;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "campusnew_id", unique = true, nullable = false)
	public Integer getCampusnewId() {
		return this.campusnewId;
	}

	public void setCampusnewId(Integer campusnewId) {
		this.campusnewId = campusnewId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "college_id", nullable = false)
	public College getCollege() {
		return this.college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "major_id", nullable = false)
	public Major getMajor() {
		return this.major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	@Column(name = "newstype", nullable = false)
	public Integer getNewstype() {
		return this.newstype;
	}

	public void setNewstype(Integer newstype) {
		this.newstype = newstype;
	}

	@Column(name = "content", nullable = false, length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "pubdate", nullable = false, length = 19)
	public Timestamp getPubdate() {
		return this.pubdate;
	}

	public void setPubdate(Timestamp pubdate) {
		this.pubdate = pubdate;
	}

	@Column(name = "level", nullable = false)
	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

}