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
 * Scenicspot entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "scenicspot", catalog = "campusassistant_web")
public class Scenicspot implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 4104724109957188782L;
	private Integer scenicspotId;
	private String spotname;
	private String description;
	private Double rateMean;
	private Integer rateNum;
	private Set<Spotcomment> spotcomments = new HashSet<Spotcomment>(0);
	private Set<Geoinfo> geoinfos = new HashSet<Geoinfo>(0);

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
	public Scenicspot(String spotname, String description, Double rateMean,
			Integer rateNum, Set<Spotcomment> spotcomments,
			Set<Geoinfo> geoinfos) {
		this.spotname = spotname;
		this.description = description;
		this.rateMean = rateMean;
		this.rateNum = rateNum;
		this.spotcomments = spotcomments;
		this.geoinfos = geoinfos;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "scenicspot")
	public Set<Spotcomment> getSpotcomments() {
		return this.spotcomments;
	}

	public void setSpotcomments(Set<Spotcomment> spotcomments) {
		this.spotcomments = spotcomments;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "scenicspot")
	public Set<Geoinfo> getGeoinfos() {
		return this.geoinfos;
	}

	public void setGeoinfos(Set<Geoinfo> geoinfos) {
		this.geoinfos = geoinfos;
	}

}