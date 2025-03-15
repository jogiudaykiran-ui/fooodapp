package com.foodapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.foodapp.dao.OrdersInterface;
import com.foodapp.model.Orders;
import com.user.connect.Connect;

public class OrdersImpl implements OrdersInterface {

	ArrayList<Orders> orders=new ArrayList<Orders>();
	static Connection con;
	static {
		con=Connect.connect();
	}
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultset;
	@Override
	public int insert(Orders o) {
	    try {
	        System.out.println("Database called");

	        // Modify the query to exclude the order_id, assuming it's auto-incremented
	        pstmt = con.prepareStatement("INSERT INTO orders (`total_amount`, `status`, `payment_mode`, `user_id`, `Restaurant_id`) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
	        System.out.println("Inserting into database");

	        pstmt.setDouble(1, o.getTotal_amount());
	        pstmt.setString(2, o.getStatus());
	        pstmt.setString(3, o.getPayment_mode());
	        pstmt.setInt(4, o.getUser_id());
	        pstmt.setInt(5, o.getRestaurant_id());

	        // Execute the insert
	        int affectedRows = pstmt.executeUpdate();

	        // If the insert was successful, retrieve the generated order_id
	        if (affectedRows > 0) {
	            ResultSet generatedKeys = pstmt.getGeneratedKeys();
	            if (generatedKeys.next()) {
	                int generatedOrderId = generatedKeys.getInt(1);
	                o.setOrder_id(generatedOrderId); // Set the generated order_id to the Orders object
	                System.out.println("Generated Order ID: " + generatedOrderId);
	            }
	        }

	        return affectedRows;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return 0;
	}

	
	@Override
	public ArrayList<Orders> fetchall() {
		try {
			System.out.println("fetching");
			stmt=con.createStatement();
			resultset=stmt.executeQuery("Select * from orders");
			System.out.println("in database fetching");

			while(resultset.next()) {

				orders.add(new Orders(resultset.getInt("order_id"),resultset.getDouble("total_amount"),resultset.getString("status"),resultset.getString("payment_mode"),resultset.getInt("user_id"),resultset.getInt("Restaurant_id")));

			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
//		finally {
//			close();
//		}
		return orders;
	}
	
		
	@Override
	public ArrayList<Orders> fetch(int o) {
	    orders.clear();  // Clear previous orders to avoid duplicates
	    try {
	        pstmt = con.prepareStatement("Select * from orders where user_id=?");
	        pstmt.setInt(1, o);
	        resultset = pstmt.executeQuery();  // Assign resultset here
	        while (resultset.next()) {
	            orders.add(new Orders(resultset.getInt("order_id"),
	                                   resultset.getDouble("total_amount"),
	                                   resultset.getString("status"),
	                                   resultset.getString("payment_mode"),
	                                   resultset.getInt("user_id"),
	                                   resultset.getInt("Restaurant_id")));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
	    return orders;
	}


	
	@Override
	public int update(Orders o) {
		try {
			pstmt=con.prepareStatement("Update orders set total_amount=?,status=?,");
			pstmt.setDouble(1, o.getTotal_amount());
			pstmt.setString(2, o.getStatus());

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
	public int delete(Orders o) {
		try {
			pstmt=con.prepareStatement("Delete FROM orders where order_id=?");
			pstmt.setInt(1, o.getOrder_id());
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
	public ArrayList<Orders> lastfetchall() {
	    ArrayList<Orders> ordersList = new ArrayList<>();
	    try {
	    	System.out.println("last database");
	        stmt = con.createStatement();
	        // Modify query to fetch orders in descending order of order_id
	        resultset = stmt.executeQuery("SELECT * FROM orders ORDER BY order_id DESC");
	        	System.out.println("fetching all from database");

	        while (resultset.next()) {
	            ordersList.add(new Orders(
	                resultset.getInt("order_id"),
	                resultset.getDouble("total_amount"),
	                resultset.getString("status"),
	                resultset.getString("payment_mode"),
	                resultset.getInt("user_id"),
	                resultset.getInt("Restaurant_id")
	            ));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
	    return ordersList;
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
