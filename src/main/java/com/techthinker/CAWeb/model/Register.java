package com.techthinker.CAWeb.model;

import java.sql.Blob;


public class Register {

	private Integer dormitory;
	private Integer majorname;
	private String username;
	private String password;
	private String newpassword;
	private String sex;
	private String email;
	private String phone;
	private Integer entrance;
	private String birthday;
	private String description;
	private Blob image; 
	
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public Integer getDormitory() {
		return dormitory;
	}
	public Integer getMajorname() {
		return majorname;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getSex() {
		return sex;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public Integer getEntrance() {
		return entrance;
	}
	public String getBirthday() {
		return birthday;
	}
	public String getDescription() {
		return description;
	}
	public Blob getImage() {
		return image;
	}

	public void setDormitory(Integer dormitory) {
		this.dormitory = dormitory;
	}
	public void setMajorname(Integer majorname) {
		this.majorname = majorname;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setEntrance(Integer entrance) {
		this.entrance = entrance;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	
}
