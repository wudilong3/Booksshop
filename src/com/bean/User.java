package com.bean;

import java.util.HashSet;
import java.util.Set;


public class User {
	private int userId;
	private String name;
	private String password;
	private String email;
	private String imgUrl;
	private Address address;
	private Set<Orders> ordersSet = new HashSet<Orders>();
	
	
	
	public Set<Orders> getOrdersSet() {
		return ordersSet;
	}
	public void setOrdersSet(Set<Orders> ordersSet) {
		this.ordersSet = ordersSet;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
}
