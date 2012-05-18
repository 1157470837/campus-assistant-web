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
 * Spotcomment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="spotcomment"
    ,catalog="campusassistant_web"
)

public class Spotcomment  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 3681830620784208100L;
	private Integer spotcommentId;
     private User user;
     private Scenicspot scenicspot;
     private String content;
     private Timestamp pubdate;
     private Integer rating;
     private String impression;


    // Constructors

    /** default constructor */
    public Spotcomment() {
    }

	/** minimal constructor */
    public Spotcomment(User user, Scenicspot scenicspot, String content, Timestamp pubdate, Integer rating) {
        this.user = user;
        this.scenicspot = scenicspot;
        this.content = content;
        this.pubdate = pubdate;
        this.rating = rating;
    }
    
    /** full constructor */
    public Spotcomment(User user, Scenicspot scenicspot, String content, Timestamp pubdate, Integer rating, String impression) {
        this.user = user;
        this.scenicspot = scenicspot;
        this.content = content;
        this.pubdate = pubdate;
        this.rating = rating;
        this.impression = impression;
    }

   
    // Property accessors
    @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="spotcomment_id", unique=true, nullable=false)

    public Integer getSpotcommentId() {
        return this.spotcommentId;
    }
    
    public void setSpotcommentId(Integer spotcommentId) {
        this.spotcommentId = spotcommentId;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="user_id", nullable=false)

    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="scenicspot_id", nullable=false)

    public Scenicspot getScenicspot() {
        return this.scenicspot;
    }
    
    public void setScenicspot(Scenicspot scenicspot) {
        this.scenicspot = scenicspot;
    }
    
    @Column(name="content", nullable=false, length=65535)

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    @Column(name="pubdate", nullable=false, length=19)

    public Timestamp getPubdate() {
        return this.pubdate;
    }
    
    public void setPubdate(Timestamp pubdate) {
        this.pubdate = pubdate;
    }
    
    @Column(name="rating", nullable=false)

    public Integer getRating() {
        return this.rating;
    }
    
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    
    @Column(name="impression")

    public String getImpression() {
        return this.impression;
    }
    
    public void setImpression(String impression) {
        this.impression = impression;
    }
   








}