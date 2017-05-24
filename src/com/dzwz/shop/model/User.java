package com.dzwz.shop.model;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String login;
	private String name;
	private String pwd;
	private String sex;
	private String phone;
	private String email;
	private String ioc;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String login, String name, String pwd, String sex,
			String phone, String email, Set forders) {
		this.login = login;
		this.name = name;
		this.pwd = pwd;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIoc() {
		return ioc;
	}

	public void setIoc(String ioc) {
		this.ioc = ioc;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", name=" + name
				+ ", pwd=" + pwd + ", sex=" + sex + ", phone=" + phone
				+ ", email=" + email + ", ioc=" + ioc + "]";
	}
	
}