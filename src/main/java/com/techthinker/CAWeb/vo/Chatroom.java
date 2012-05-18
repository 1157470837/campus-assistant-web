package com.techthinker.CAWeb.vo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Chatroom entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "chatroom", catalog = "campusassistant_web")
public class Chatroom implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -214209130405893843L;
	private Integer chatroomId;
	private Grade grade;
	private College college;
	private Major major;
	private String chatroomName;
	private Integer parentroomId;
	private String image;
	private Integer level;
	private Set<Message> messages = new HashSet<Message>(0);

	// Constructors

	/** default constructor */
	public Chatroom() {
	}

	/** minimal constructor */
	public Chatroom(Grade grade, College college, Major major,
			String chatroomName, Integer parentroomId, Integer level) {
		this.grade = grade;
		this.college = college;
		this.major = major;
		this.chatroomName = chatroomName;
		this.parentroomId = parentroomId;
		this.level = level;
	}

	/** full constructor */
	public Chatroom(Grade grade, College college, Major major,
			String chatroomName, Integer parentroomId, String image,
			Integer level, Set<Message> messages) {
		this.grade = grade;
		this.college = college;
		this.major = major;
		this.chatroomName = chatroomName;
		this.parentroomId = parentroomId;
		this.image = image;
		this.level = level;
		this.messages = messages;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "chatroom_id", unique = true, nullable = false)
	public Integer getChatroomId() {
		return this.chatroomId;
	}

	public void setChatroomId(Integer chatroomId) {
		this.chatroomId = chatroomId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "grade_id", nullable = false)
	public Grade getGrade() {
		return this.grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
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

	@Column(name = "chatroom_name", nullable = false, length = 30)
	public String getChatroomName() {
		return this.chatroomName;
	}

	public void setChatroomName(String chatroomName) {
		this.chatroomName = chatroomName;
	}

	@Column(name = "parentroom_id", nullable = false)
	public Integer getParentroomId() {
		return this.parentroomId;
	}

	public void setParentroomId(Integer parentroomId) {
		this.parentroomId = parentroomId;
	}

	@Column(name = "image")
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "level", nullable = false)
	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "chatroom")
	public Set<Message> getMessages() {
		return this.messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

}