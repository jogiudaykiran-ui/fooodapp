package com.foodapp.dao;

import java.util.ArrayList;

import com.foodapp.model.Restaurent;

public interface RestaurentInterface {
	
	public int insert(Restaurent r);
	public ArrayList<Restaurent> fetchall();
	public ArrayList<Restaurent> fetch(Restaurent r);
	public int update(Restaurent r);
	public int delete(Restaurent r);
	public void close();
	

}
