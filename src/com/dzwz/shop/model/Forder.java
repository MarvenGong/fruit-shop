package com.dzwz.shop.model;


/**
 * Forder entity. @author MyEclipse Persistence Tools
 */

public class Forder implements java.io.Serializable {

	// Fields

	public Forder(Integer id) {
		super();
		this.id = id;
	}

	private Integer id;
	private String user;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	private int status;
	private String name;
	private String phone;
	private String remak;
	private Double price;
	private String createdate;
	private String post;
	private String address;

	// Constructors

	/** default constructor */
	public Forder() {
	}

	// Property accessors

	@Override
	public String toString() {
		return "Forder [id=" + id + ", user=" + user + ", status=" + status
				+ ", name=" + name + ", phone=" + phone + ", remak=" + remak
				+ ", price=" + price + ", createdate=" + createdate + ", post="
				+ post + ", address=" + address + "]";
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRemak() {
		return this.remak;
	}

	public void setRemak(String remak) {
		this.remak = remak;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getPost() {
		return this.post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}