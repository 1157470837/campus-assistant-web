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
 * Relation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="relation"
    ,catalog="campusassistant_web"
)

public class Relation  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = -8011139444779110219L;
	private Integer relationId;
     private User userByUserId2;
     private User userByUserId1;


    // Constructors

    /** default constructor */
    public Relation() {
    }

    
    /** full constructor */
    public Relation(User userByUserId2, User userByUserId1) {
        this.userByUserId2 = userByUserId2;
        this.userByUserId1 = userByUserId1;
    }

   
    // Property accessors
    @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="relation_id", unique=true, nullable=false)

    public Integer getRelationId() {
        return this.relationId;
    }
    
    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="user_id2", nullable=false)

    public User getUserByUserId2() {
        return this.userByUserId2;
    }
    
    public void setUserByUserId2(User userByUserId2) {
        this.userByUserId2 = userByUserId2;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="user_id1", nullable=false)

    public User getUserByUserId1() {
        return this.userByUserId1;
    }
    
    public void setUserByUserId1(User userByUserId1) {
        this.userByUserId1 = userByUserId1;
    }
   








}