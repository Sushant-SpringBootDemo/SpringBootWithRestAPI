package com.zensar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

	private int UserId;
	private int Id;
	private String Title;
	private String Body;

	public User() {
	}

	
	public User(int userId, int id, String title, String body) {
		super();
		UserId = userId;
		Id = id;
		Title = title;
		Body = body;
	}


	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getBody() {
		return Body;
	}

	public void setBody(String body) {
		Body = body;
	}

	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", Id=" + Id + ", Title=" + Title + ", Body=" + Body + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + UserId;
		return result;
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
		if (UserId != other.UserId)
			return false;
		return true;
	}

	
	
	
	

}
