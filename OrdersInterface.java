package com.foodapp.dao;

import java.util.ArrayList;

import com.foodapp.model.Orders;

public interface OrdersInterface {

	public int insert(Orders o);
	public ArrayList<Orders> fetchall();
	public ArrayList<Orders> fetch(int o);
	public int update(Orders o);
	public int delete(Orders o);
	public void close();
	public ArrayList<Orders> lastfetchall(); 
}
