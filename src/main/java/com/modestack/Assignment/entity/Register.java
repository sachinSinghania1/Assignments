package com.modestack.Assignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "UserRegister")
public class Register {
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	@Column(unique = false, length = 40)
	private String userName;
	
	@Column(unique = false, length = 40)
	private String password;
	
	@Column(unique = false, length = 40)
	private String email;
	
	@Column(unique = false, length = 40)
	private String address;

	public Register(int userId, String userName, String password, String email, String address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.address = address;
	}

	public Register() {
		super();
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}