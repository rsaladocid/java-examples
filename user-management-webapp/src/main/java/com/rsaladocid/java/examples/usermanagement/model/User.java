package com.rsaladocid.java.examples.usermanagement.model;

public class User {
	
	private String mail;
	private String password;
	private String username;
	private String name;
	private String bio;
	private String avatar;
	private String site;
	
	public User() {
		this(null, null);
	}
	
	public User(String mail, String password) {
		this.mail = mail;
		this.password = password;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getAvatar() {
		return avatar;
	}
	
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public String getSite() {
		return site;
	}
	
	public void setSite(String site) {
		this.site = site;
	}
	
	@Override
	public String toString() {
		if (getName() != null) {
			return getName(); 
		} else if (getUsername() != null) {
			return getUsername();
		}
		
		return getMail();
	}

}
