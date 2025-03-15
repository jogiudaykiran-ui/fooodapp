package com.foodapp.dao;

import java.util.ArrayList;
import java.util.List;

import com.foodapp.model.Menu;


public interface MenuInterface {

	public int insert(Menu m);
	public ArrayList<Menu> fetchAll();
	public Menu fetch(int ItemId);
	public List<Menu> fetchMenuByRestaurant(int Restaurant_id);
	public int update(Menu m);
	public int delete(Menu m);
	public List<Menu> searchMenu(String keyword);
	public void close();
}
