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
 * Scenicspot entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "scenicspot", catalog = "campusassistant_web")
public class Scenicspot implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8532003278219648800L;
	private Integer scenicspotId;
	private Geoinfo geoinfo;
	private String spotname;
	private String description;
	private Double rateMean;
	private Integer rateNum;
	private String image;
	private Set<Spotcomment> spotcomments = new HashSet<Spotcomment>(0);
	private Set<College> colleges = new HashSet<College>(0);

	// Constructors

	/** default constructor */
	public Scenicspot() {
	}

	/** minimal constructor */
	public Scenicspot(String spotname, String description) {
		this.spotname = spotname;
		this.description = description;
	}

	/** full constructor */
	public Scenicspot(Geoinfo geoinfo, String spotname, String description,
			Double rateMean, Integer rateNum, String image,
			Set<Spotcomment> spotcomments, Set<College> colleges) {
		this.geoinfo = geoinfo;
		this.spotname = spotname;
		this.description = description;
		this.rateMean = rateMean;
		this.rateNum = rateNum;
		this.image = image;
		this.spotcomments = spotcomments;
		this.colleges = colleges;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "scenicspot_id", unique = true, nullable = false)
	public Integer getScenicspotId() {
		return this.scenicspotId;
	}

	public void setScenicspotId(Integer scenicspotId) {
		this.scenicspotId = scenicspotId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "geoinfo_id")
	public Geoinfo getGeoinfo() {
		return this.geoinfo;
	}

	public void setGeoinfo(Geoinfo geoinfo) {
		this.geoinfo = geoinfo;
	}

	@Column(name = "spotname", nullable = false, length = 45)
	public String getSpotname() {
		return this.spotname;
	}

	public void setSpotname(String spotname) {
		this.spotname = spotname;
	}

	@Column(name = "description", nullable = false, length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "rate_mean", precision = 22, scale = 0)
	public Double getRateMean() {
		return this.rateMean;
	}

	public void setRateMean(Double rateMean) {
		this.rateMean = rateMean;
	}

	@Column(name = "rate_num")
	public Integer getRateNum() {
		return this.rateNum;
	}

	public void setRateNum(Integer rateNum) {
		this.rateNum = rateNum;
	}

	@Column(name = "image")
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "scenicspot")
	public Set<Spotcomment> getSpotcomments() {
		return this.spotcomments;
	}

	public void setSpotcomments(Set<Spotcomment> spotcomments) {
		this.spotcomments = spotcomments;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "scenicspot")
	public Set<College> getColleges() {
		return this.colleges;
	}

	public void setColleges(Set<College> colleges) {
		this.colleges = colleges;
	}

}