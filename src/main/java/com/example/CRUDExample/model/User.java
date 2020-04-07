package com.example.CRUDExample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	private long userId;
	private String username;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User(long userId, String username) {
		super();
		this.userId = userId;
		this.username = username;
	}

	public User(long userId) {
		super();
		this.userId = userId;
	}

	public User() {
		super();
	}

}
