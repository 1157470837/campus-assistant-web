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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * College entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "college", catalog = "campusassistant_web")
public class College implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6686982411800059713L;
	private Integer collegeId;
	private String collegeName;
	private String description;
	private String image;
	private Set<User> users = new HashSet<User>(0);
	private Set<Campusnews> campusnewses = new HashSet<Campusnews>(0);
	private Set<Grade> grades = new HashSet<Grade>(0);
	private Set<Chatroom> chatrooms = new HashSet<Chatroom>(0);
	private Set<Major> majors = new HashSet<Major>(0);
	private Set<Geoinfo> geoinfos = new HashSet<Geoinfo>(0);

	// Constructors

	/** default constructor */
	public College() {
	}

	/** minimal constructor */
	public College(String collegeName, String description) {
		this.collegeName = collegeName;
		this.description = description;
	}

	/** full constructor */
	public College(String collegeName, String description, String image,
			Set<User> users, Set<Campusnews> campusnewses, Set<Grade> grades,
			Set<Chatroom> chatrooms, Set<Major> majors, Set<Geoinfo> geoinfos) {
		this.collegeName = collegeName;
		this.description = description;
		this.image = image;
		this.users = users;
		this.campusnewses = campusnewses;
		this.grades = grades;
		this.chatrooms = chatrooms;
		this.majors = majors;
		this.geoinfos = geoinfos;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "college_id", unique = true, nullable = false)
	public Integer getCollegeId() {
		return this.collegeId;
	}

	public void setCollegeId(Integer collegeId) {
		this.collegeId = collegeId;
	}

	@Column(name = "college_name", nullable = false, length = 30)
	public String getCollegeName() {
		return this.collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "college")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "college")
	public Set<Campusnews> getCampusnewses() {
		return this.campusnewses;
	}

	public void setCampusnewses(Set<Campusnews> campusnewses) {
		this.campusnewses = campusnewses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "college")
	public Set<Grade> getGrades() {
		return this.grades;
	}

	public void setGrades(Set<Grade> grades) {
		this.grades = grades;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "college")
	public Set<Chatroom> getChatrooms() {
		return this.chatrooms;
	}

	public void setChatrooms(Set<Chatroom> chatrooms) {
		this.chatrooms = chatrooms;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "college")
	public Set<Major> getMajors() {
		return this.majors;
	}

	public void setMajors(Set<Major> majors) {
		this.majors = majors;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "college")
	public Set<Geoinfo> getGeoinfos() {
		return this.geoinfos;
	}

	public void setGeoinfos(Set<Geoinfo> geoinfos) {
		this.geoinfos = geoinfos;
	}

}