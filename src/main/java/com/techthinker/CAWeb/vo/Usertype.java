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
@Table(name="usertype"
    ,catalog="campusassistant_web"
)

public class Usertype  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = -905605613100028269L;
	private Integer usertypeId;
     private Integer usertypeName;
     private Set<User> users = new HashSet<User>(0);


    // Constructors

    /** default constructor */
    public Usertype() {
    }

	/** minimal constructor */
    public Usertype(Integer usertypeName) {
        this.usertypeName = usertypeName;
    }
    
    /** full constructor */
    public Usertype(Integer usertypeName, Set<User> users) {
        this.usertypeName = usertypeName;
        this.users = users;
    }

   
    // Property accessors
    @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="usertype_id", unique=true, nullable=false)

    public Integer getUsertypeId() {
        return this.usertypeId;
    }
    
    public void setUsertypeId(Integer usertypeId) {
        this.usertypeId = usertypeId;
    }
    
    @Column(name="usertype_name", nullable=false)

    public Integer getUsertypeName() {
        return this.usertypeName;
    }
    
    public void setUsertypeName(Integer usertypeName) {
        this.usertypeName = usertypeName;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="usertype")

    public Set<User> getUsers() {
        return this.users;
    }
    
    public void setUsers(Set<User> users) {
        this.users = users;
    }
   








}