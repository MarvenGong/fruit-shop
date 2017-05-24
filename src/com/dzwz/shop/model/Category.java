package com.dzwz.shop.model;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */

public class Category implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String type;
	private Boolean hot;
	private Account account;

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** full constructor */
	public Category(String type, Boolean hot) {
		this.type = type;
		this.hot = hot;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getHot() {
		return this.hot;
	}

	public void setHot(Boolean hot) {
		this.hot = hot;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}



	
	
}