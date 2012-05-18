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
 * Major entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "major", catalog = "campusassistant_web")
public class Major implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7197980652261641568L;
	private Integer majorId;
	private College college;
	private String majorName;
	private String description;
	private String image;
	private Set<Campusnews> campusnewses = new HashSet<Campusnews>(0);
	private Set<User> users = new HashSet<User>(0);
	private Set<Grade> grades = new HashSet<Grade>(0);
	private Set<Chatroom> chatrooms = new HashSet<Chatroom>(0);

	// Constructors

	/** default constructor */
	public Major() {
	}

	/** minimal constructor */
	public Major(College college, String majorName, String description) {
		this.college = college;
		this.majorName = majorName;
		this.description = description;
	}

	/** full constructor */
	public Major(College college, String majorName, String description,
			String image, Set<Campusnews> campusnewses, Set<User> users,
			Set<Grade> grades, Set<Chatroom> chatrooms) {
		this.college = college;
		this.majorName = majorName;
		this.description = description;
		this.image = image;
		this.campusnewses = campusnewses;
		this.users = users;
		this.grades = grades;
		this.chatrooms = chatrooms;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "major_id", unique = true, nullable = false)
	public Integer getMajorId() {
		return this.majorId;
	}

	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "college_id", nullable = false)
	public College getCollege() {
		return this.college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	@Column(name = "major_name", nullable = false, length = 30)
	public String getMajorName() {
		return this.majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	@Column(name = "description", nullable = false, length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "image")
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "major")
	public Set<Campusnews> getCampusnewses() {
		return this.campusnewses;
	}

	public void setCampusnewses(Set<Campusnews> campusnewses) {
		this.campusnewses = campusnewses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "major")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "major")
	public Set<Grade> getGrades() {
		return this.grades;
	}

	public void setGrades(Set<Grade> grades) {
		this.grades = grades;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "major")
	public Set<Chatroom> getChatrooms() {
		return this.chatrooms;
	}

	public void setChatrooms(Set<Chatroom> chatrooms) {
		this.chatrooms = chatrooms;
	}

}