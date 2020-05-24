package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue
	private int id;

	private String userName;

	private String emailAddress;

	public User() {
	}

	public User(String userName, String emailAddress) {
		this.userName = userName;
		this.emailAddress = emailAddress;
	}

	public User(int id, String userName, String emailAddress) {
		this.id = id;
		this.userName = userName;
		this.emailAddress = emailAddress;
	}

	public String getUserName() {
		return userName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		User user = (User) o;

		if (id != user.id)
			return false;
		if (!userName.equals(user.userName))
			return false;
		return emailAddress.equals(user.emailAddress);

	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + userName.hashCode();
		result = 31 * result + emailAddress.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "User{" + "userId=" + id + ", userName='" + userName + '\'' + ", emailAddress='" + emailAddress + '\''
				+ '}';
	}
}
