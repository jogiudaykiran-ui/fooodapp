package com.foodapp.dao;

import java.util.ArrayList;

import com.foodapp.model.Order_Items;



public interface Orders_Items_Interfaces {
	
	public int insert(Order_Items o);
	public ArrayList<Order_Items> fetchall();
	public ArrayList<Order_Items> fetch(Order_Items o);
	public int update(Order_Items o);
	public int delete(Order_Items o);
	public void close();

}
