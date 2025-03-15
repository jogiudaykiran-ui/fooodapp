package com.foodapp.dao;

import java.util.ArrayList;

import com.foodapp.model.User;

public interface UserInterface {

	public int insert(User u);
	public ArrayList<User> fetchAll();
	public ArrayList<User> fetch(User u);
	public int update(String password, String email);
	public int delete(User u);
	public void close();
}
