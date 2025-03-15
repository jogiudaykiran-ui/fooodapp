package com.foodapp.dao;

import java.util.ArrayList;

import com.foodapp.model.Orders_History;

public interface Orders_history_interface {

	public int insert(Orders_History o);
	public ArrayList<Orders_History> fetchAll();
	public ArrayList<Orders_History> fetch(Orders_History o);
	public int update(Orders_History o);
	public int delete(Orders_History o);
	public void close();
}
