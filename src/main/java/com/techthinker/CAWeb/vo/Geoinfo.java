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
 * Geoinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "geoinfo", catalog = "campusassistant_web")
public class Geoinfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8734836975256720597L;
	private Integer geoinfoId;
	private Double longtitude1;
	private Double longtitude2;
	private Double longtitude3;
	private Double longtitude4;
	private Double latitude1;
	private Double latitude2;
	private Double latitude3;
	private Double latitude4;
	private Boolean availabe;
	private Set<Scenicspot> scenicspots = new HashSet<Scenicspot>(0);
	private Set<User> users = new HashSet<User>(0);

	// Constructors

	/** default constructor */
	public Geoinfo() {
	}

	/** minimal constructor */
	public Geoinfo(Double longtitude1, Double longtitude2, Double longtitude3,
			Double longtitude4, Double latitude1, Double latitude2,
			Double latitude3, Double latitude4, Boolean availabe) {
		this.longtitude1 = longtitude1;
		this.longtitude2 = longtitude2;
		this.longtitude3 = longtitude3;
		this.longtitude4 = longtitude4;
		this.latitude1 = latitude1;
		this.latitude2 = latitude2;
		this.latitude3 = latitude3;
		this.latitude4 = latitude4;
		this.availabe = availabe;
	}

	/** full constructor */
	public Geoinfo(Double longtitude1, Double longtitude2, Double longtitude3,
			Double longtitude4, Double latitude1, Double latitude2,
			Double latitude3, Double latitude4, Boolean availabe,
			Set<Scenicspot> scenicspots, Set<User> users) {
		this.longtitude1 = longtitude1;
		this.longtitude2 = longtitude2;
		this.longtitude3 = longtitude3;
		this.longtitude4 = longtitude4;
		this.latitude1 = latitude1;
		this.latitude2 = latitude2;
		this.latitude3 = latitude3;
		this.latitude4 = latitude4;
		this.availabe = availabe;
		this.scenicspots = scenicspots;
		this.users = users;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "geoinfo_id", unique = true, nullable = false)
	public Integer getGeoinfoId() {
		return this.geoinfoId;
	}

	public void setGeoinfoId(Integer geoinfoId) {
		this.geoinfoId = geoinfoId;
	}

	@Column(name = "longtitude1", nullable = false, precision = 22, scale = 0)
	public Double getLongtitude1() {
		return this.longtitude1;
	}

	public void setLongtitude1(Double longtitude1) {
		this.longtitude1 = longtitude1;
	}

	@Column(name = "longtitude2", nullable = false, precision = 22, scale = 0)
	public Double getLongtitude2() {
		return this.longtitude2;
	}

	public void setLongtitude2(Double longtitude2) {
		this.longtitude2 = longtitude2;
	}

	@Column(name = "longtitude3", nullable = false, precision = 22, scale = 0)
	public Double getLongtitude3() {
		return this.longtitude3;
	}

	public void setLongtitude3(Double longtitude3) {
		this.longtitude3 = longtitude3;
	}

	@Column(name = "longtitude4", nullable = false, precision = 22, scale = 0)
	public Double getLongtitude4() {
		return this.longtitude4;
	}

	public void setLongtitude4(Double longtitude4) {
		this.longtitude4 = longtitude4;
	}

	@Column(name = "latitude1", nullable = false, precision = 22, scale = 0)
	public Double getLatitude1() {
		return this.latitude1;
	}

	public void setLatitude1(Double latitude1) {
		this.latitude1 = latitude1;
	}

	@Column(name = "latitude2", nullable = false, precision = 22, scale = 0)
	public Double getLatitude2() {
		return this.latitude2;
	}

	public void setLatitude2(Double latitude2) {
		this.latitude2 = latitude2;
	}

	@Column(name = "latitude3", nullable = false, precision = 22, scale = 0)
	public Double getLatitude3() {
		return this.latitude3;
	}

	public void setLatitude3(Double latitude3) {
		this.latitude3 = latitude3;
	}

	@Column(name = "latitude4", nullable = false, precision = 22, scale = 0)
	public Double getLatitude4() {
		return this.latitude4;
	}

	public void setLatitude4(Double latitude4) {
		this.latitude4 = latitude4;
	}

	@Column(name = "availabe", nullable = false)
	public Boolean getAvailabe() {
		return this.availabe;
	}

	public void setAvailabe(Boolean availabe) {
		this.availabe = availabe;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "geoinfo")
	public Set<Scenicspot> getScenicspots() {
		return this.scenicspots;
	}

	public void setScenicspots(Set<Scenicspot> scenicspots) {
		this.scenicspots = scenicspots;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "geoinfo")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}