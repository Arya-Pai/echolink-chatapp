package com.echolink.model;

public class User {
	private long id;
	private String username;
	private String password;
	private String email;
	
	public User(String username,String email,String password) {
		this.username=username;
		this.email=email;
		this.password=password;
	}
	public User(long id,String username) {
		this.id=id;
		this.username=username;
	}
	
	public long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setUsername(String username) {
		this.username=username;
	}
	public void setEmail(String email) {
		 this.email=email;
	}
	public void setPassword(String password) {
		this.password=password;
	}
}
