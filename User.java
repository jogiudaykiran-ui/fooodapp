package com.foodapp.model;

public class User {
	
	private int user_id;
	private String user_name;
	private String password;
	private String email;
	private String adress;
	
	public User() {
		
	}
	public User( String user_name, String password, String email, String adress) {
		super();
		this.user_name = user_name;
		this.password = password;
		this.email = email;
		this.adress = adress;
	}
	public User(int user_id, String user_name, String password, String email, String adress) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.password = password;
		this.email = email;
		this.adress = adress;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
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
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", password=" + password + ", email=" + email
				+ ", adress=" + adress + "]";
	}
	
	
	
}
