package com.model;

import java.util.Objects;

public class User {
	@Override
	public int hashCode() {
		return Objects.hash(userId, userName, userPassword, userRole);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return userId == other.userId && Objects.equals(userName, other.userName)
				&& Objects.equals(userPassword, other.userPassword) && Objects.equals(userRole, other.userRole);
	}

	private int userId;
	private String userName;
	private String userPassword;
	private String userRole;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String userName, String userPassword, String userRole) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userRole = userRole;
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

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userRole="
				+ userRole + "]";
	}
}
