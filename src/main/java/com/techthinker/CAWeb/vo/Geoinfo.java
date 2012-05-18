package com.techthinker.CAWeb.vo;

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
 * Geoinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "geoinfo", catalog = "campusassistant_web")
public class Geoinfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5665754040316880043L;
	private Integer geoinfoId;
	private User user;
	private College college;
	private Scenicspot scenicspot;
	private Double longtitude;
	private Double latitude;
	private Integer spottype;

	// Constructors

	/** default constructor */
	public Geoinfo() {
	}

	/** full constructor */
	public Geoinfo(User user, College college, Scenicspot scenicspot,
			Double longtitude, Double latitude, Integer spottype) {
		this.user = user;
		this.college = college;
		this.scenicspot = scenicspot;
		this.longtitude = longtitude;
		this.latitude = latitude;
		this.spottype = spottype;
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
	@JoinColumn(name = "scenicspot_id", nullable = false)
	public Scenicspot getScenicspot() {
		return this.scenicspot;
	}

	public void setScenicspot(Scenicspot scenicspot) {
		this.scenicspot = scenicspot;
	}

	@Column(name = "longtitude", nullable = false, precision = 22, scale = 0)
	public Double getLongtitude() {
		return this.longtitude;
	}

	public void setLongtitude(Double longtitude) {
		this.longtitude = longtitude;
	}

	@Column(name = "latitude", nullable = false, precision = 22, scale = 0)
	public Double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	@Column(name = "spottype", nullable = false)
	public Integer getSpottype() {
		return this.spottype;
	}

	public void setSpottype(Integer spottype) {
		this.spottype = spottype;
	}

}