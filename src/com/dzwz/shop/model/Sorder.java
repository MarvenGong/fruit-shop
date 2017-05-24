package com.dzwz.shop.model;

/**
 * Sorder entity. @author MyEclipse Persistence Tools
 */

public class Sorder implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer fid;
	private Product product;
	private String name;
	private Double price;
	private Integer number;

	// Constructors

	/** default constructor */
	public Sorder() {
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

}