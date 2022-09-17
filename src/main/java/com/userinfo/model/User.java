package com.userinfo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CUSTOMER_USER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	public User(int userId, String userName, String userPhNumber, String userAddress, String userDesignation) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPhNumber = userPhNumber;
		this.userAddress = userAddress;
		this.userDesignation = userDesignation;
	}

	public User() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_phnumber")
	private String userPhNumber;

	@Column(name = "user_address")
	private String userAddress;

	@Column(name = "user_designation")
	private String userDesignation;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhNumber() {
		return userPhNumber;
	}

	public void setUserPhNumber(String userPhNumber) {
		this.userPhNumber = userPhNumber;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserDesignation() {
		return userDesignation;
	}

	public void setUserDesignation(String userDesignation) {
		this.userDesignation = userDesignation;
	}

}
