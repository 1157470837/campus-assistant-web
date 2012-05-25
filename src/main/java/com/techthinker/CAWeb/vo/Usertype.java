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
 * Usertype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "usertype", catalog = "campusassistant_web")
public class Usertype implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 837789390677982926L;
	private Integer usertypeId;
	private String usertypeName;
	private Integer usertypeNum;
	private Set<User> users = new HashSet<User>(0);

	// Constructors

	/** default constructor */
	public Usertype() {
	}

	/** minimal constructor */
	public Usertype(String usertypeName, Integer usertypeNum) {
		this.usertypeName = usertypeName;
		this.usertypeNum = usertypeNum;
	}

	/** full constructor */
	public Usertype(String usertypeName, Integer usertypeNum, Set<User> users) {
		this.usertypeName = usertypeName;
		this.usertypeNum = usertypeNum;
		this.users = users;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "usertype_id", unique = true, nullable = false)
	public Integer getUsertypeId() {
		return this.usertypeId;
	}

	public void setUsertypeId(Integer usertypeId) {
		this.usertypeId = usertypeId;
	}

	@Column(name = "usertype_name", nullable = false, length = 30)
	public String getUsertypeName() {
		return this.usertypeName;
	}

	public void setUsertypeName(String usertypeName) {
		this.usertypeName = usertypeName;
	}

	@Column(name = "usertype_num", nullable = false)
	public Integer getUsertypeNum() {
		return this.usertypeNum;
	}

	public void setUsertypeNum(Integer usertypeNum) {
		this.usertypeNum = usertypeNum;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usertype")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}