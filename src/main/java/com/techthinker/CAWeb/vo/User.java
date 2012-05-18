package com.techthinker.CAWeb.vo;

import java.sql.Timestamp;
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
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "campusassistant_web")
public class User implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 3661194912693800204L;
	private Integer userId;
	private College college;
	private Major major;
	private Usertype usertype;
	private String username;
	private String password;
	private String sex;
	private String email;
	private String phone;
	private Integer entranceYear;
	private Timestamp birthday;
	private String description;
	private String image;
	private Set<Question> questions = new HashSet<Question>(0);
	private Set<Geoinfo> geoinfos = new HashSet<Geoinfo>(0);
	private Set<Campusnews> campusnewses = new HashSet<Campusnews>(0);
	private Set<Spotcomment> spotcomments = new HashSet<Spotcomment>(0);
	private Set<Relation> relationsForUserId1 = new HashSet<Relation>(0);
	private Set<Message> messagesForTouserId = new HashSet<Message>(0);
	private Set<Relation> relationsForUserId2 = new HashSet<Relation>(0);
	private Set<Message> messagesForUserId = new HashSet<Message>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(College college, Major major, Usertype usertype,
			String username, String password, String sex, String email) {
		this.college = college;
		this.major = major;
		this.usertype = usertype;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.email = email;
	}

	/** full constructor */
	public User(College college, Major major, Usertype usertype,
			String username, String password, String sex, String email,
			String phone, Integer entranceYear, Timestamp birthday,
			String description, String image, Set<Question> questions,
			Set<Geoinfo> geoinfos, Set<Campusnews> campusnewses,
			Set<Spotcomment> spotcomments, Set<Relation> relationsForUserId1,
			Set<Message> messagesForTouserId,
			Set<Relation> relationsForUserId2, Set<Message> messagesForUserId) {
		this.college = college;
		this.major = major;
		this.usertype = usertype;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.email = email;
		this.phone = phone;
		this.entranceYear = entranceYear;
		this.birthday = birthday;
		this.description = description;
		this.image = image;
		this.questions = questions;
		this.geoinfos = geoinfos;
		this.campusnewses = campusnewses;
		this.spotcomments = spotcomments;
		this.relationsForUserId1 = relationsForUserId1;
		this.messagesForTouserId = messagesForTouserId;
		this.relationsForUserId2 = relationsForUserId2;
		this.messagesForUserId = messagesForUserId;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usertype_id", nullable = false)
	public Usertype getUsertype() {
		return this.usertype;
	}

	public void setUsertype(Usertype usertype) {
		this.usertype = usertype;
	}

	@Column(name = "username", nullable = false, length = 20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "sex", nullable = false, length = 4)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "email", nullable = false, length = 30)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone", length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "entrance_year")
	public Integer getEntranceYear() {
		return this.entranceYear;
	}

	public void setEntranceYear(Integer entranceYear) {
		this.entranceYear = entranceYear;
	}

	@Column(name = "birthday", length = 19)
	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	@Column(name = "description", length = 65535)
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Geoinfo> getGeoinfos() {
		return this.geoinfos;
	}

	public void setGeoinfos(Set<Geoinfo> geoinfos) {
		this.geoinfos = geoinfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Campusnews> getCampusnewses() {
		return this.campusnewses;
	}

	public void setCampusnewses(Set<Campusnews> campusnewses) {
		this.campusnewses = campusnewses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Spotcomment> getSpotcomments() {
		return this.spotcomments;
	}

	public void setSpotcomments(Set<Spotcomment> spotcomments) {
		this.spotcomments = spotcomments;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByUserId1")
	public Set<Relation> getRelationsForUserId1() {
		return this.relationsForUserId1;
	}

	public void setRelationsForUserId1(Set<Relation> relationsForUserId1) {
		this.relationsForUserId1 = relationsForUserId1;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByTouserId")
	public Set<Message> getMessagesForTouserId() {
		return this.messagesForTouserId;
	}

	public void setMessagesForTouserId(Set<Message> messagesForTouserId) {
		this.messagesForTouserId = messagesForTouserId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByUserId2")
	public Set<Relation> getRelationsForUserId2() {
		return this.relationsForUserId2;
	}

	public void setRelationsForUserId2(Set<Relation> relationsForUserId2) {
		this.relationsForUserId2 = relationsForUserId2;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByUserId")
	public Set<Message> getMessagesForUserId() {
		return this.messagesForUserId;
	}

	public void setMessagesForUserId(Set<Message> messagesForUserId) {
		this.messagesForUserId = messagesForUserId;
	}

}