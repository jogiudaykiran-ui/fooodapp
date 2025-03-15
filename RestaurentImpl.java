package com.foodapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.foodapp.dao.RestaurentInterface;
import com.foodapp.model.Restaurent;
import com.user.connect.Connect;

public class RestaurentImpl implements RestaurentInterface {

	ArrayList<Restaurent> restaurentList=new ArrayList<Restaurent>();
	static Connection con;
	static{
		con = Connect.connect();
	}


	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultset;

	@Override
	public int insert(Restaurent r) {

		try {
			pstmt=con.prepareStatement("INSERT INTO `foodapp`.`restaurant` (`Restaurant_id`, `Restaurant_name`, `Cuisine_type`, `Delivery_time`, `Restaurant_adress`, `Restaurant_rating`, `Restaurant_isActive`) VALUES (?, ?, ?, ?, ?, ?, ?);");
			pstmt.setInt(1, r.getRestaurant_id());
			pstmt.setString(2, r.getRestaurant_name());
			pstmt.setString(3, r.getCuisine_type());
			pstmt.setInt(4, r.getDelivery_time());
			pstmt.setString(5, r.getRestaurant_adress());
			pstmt.setFloat(6, r.getRestaurant_rating());
			pstmt.setInt(7, r.getRestaurant_isActive());

			return pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
		return 0;


	}
	@Override
	public ArrayList<Restaurent> fetchall(){
		try {
			stmt=con.createStatement();
			resultset=stmt.executeQuery("Select * from restaurant");
			
			while(resultset.next()) {

				restaurentList.add(new Restaurent(resultset.getInt("Restaurant_id"),resultset.getString("Restaurant_name"),resultset.getString("Cuisine_type"),resultset.getInt("Delivery_time"),resultset.getString("Restaurant_adress"),resultset.getFloat("Restaurant_rating"),resultset.getInt("Restaurant_isActive"),resultset.getString("Restauran_imagePath")));

			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return restaurentList;
	}
	@Override
	public ArrayList<Restaurent> fetch(Restaurent r) {

		try {
			pstmt=con.prepareStatement("Select * from menu where Restaurent_id=?");
			pstmt.setInt(1, r.getRestaurant_id());
			resultset=pstmt.executeQuery();

			while(resultset.next()) {

				restaurentList.add(new Restaurent(resultset.getInt("Restaurant_id"),resultset.getString("Restaurant_name"),resultset.getString("Cuisine_type"),resultset.getInt("Delivery_time"),resultset.getString("Restaurant_adress"),resultset.getFloat("Restaurant_rating"),resultset.getInt("Restaurant_isActive"),resultset.getString("Restaurant_imagePath")));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
		return restaurentList;
	}

	@Override
	public int update(Restaurent r) {
		try {
			pstmt=con.prepareStatement("Update restaurant set Delivery_time=?,Restaurant_isActive=?");
			pstmt.setInt(1, r.getDelivery_time());
			pstmt.setInt(2, r.getRestaurant_isActive());

			return pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
		return 0;
	}
	@Override
	public int delete(Restaurent r) {
		try {
			pstmt=con.prepareStatement("Delete FROM restaurant where Restaurant_id=?");
			pstmt.setInt(1, r.getRestaurant_id());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
		return 0;
	}
	@Override
	public void close() {

		try {
			con.close();
			pstmt.close();
			stmt.close();
			resultset.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	
}
