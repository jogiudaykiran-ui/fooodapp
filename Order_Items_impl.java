package com.foodapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.foodapp.dao.Orders_Items_Interfaces;
import com.foodapp.model.Order_Items;
import com.user.connect.Connect;

public class Order_Items_impl implements Orders_Items_Interfaces{
	ArrayList<Order_Items> oi=new ArrayList<Order_Items>();
	static Connection con;
	static {
		con=Connect.connect();
	}

	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultset;

	@Override
	public int insert(Order_Items o) {
	    try {
	        System.out.println("Inserting into database");

	        // Prepare the SQL statement to insert order item
	        pstmt = con.prepareStatement("INSERT INTO orderitems (`order_id`, `menu_id`, `quantity`, `items_total`) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
	        
	        pstmt.setInt(1, o.getOrder_id());
	        pstmt.setInt(2, o.getMenu_id());
	        pstmt.setInt(3, o.getQuanttity());
	        pstmt.setInt(4, o.getItems_total());

	        // Execute the insert
	        int affectedRows = pstmt.executeUpdate();
	        
	       
	        if (affectedRows > 0) {
	            // Get the generated order_item_id
	            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                    int generatedId = generatedKeys.getInt(1);
	                    o.setOrder_items_id(generatedId);  // Set the generated order_item_id in the Order_Items object
	                    System.out.println("Generated order_item_id: " + generatedId);
	                    return generatedId;  // Return the generated order_item_id
	                }
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return 0;  // Return 0 if the insertion fails
	}


	@Override
	public ArrayList<Order_Items> fetchall() {
	    try {
	        stmt = con.createStatement();
	        resultset = stmt.executeQuery("SELECT * FROM orderitems");

	        while (resultset.next()) {
	            oi.add(new Order_Items(resultset.getInt("order_item_id"),
	                                   resultset.getInt("order_id"),
	                                   resultset.getInt("menu_id"),
	                                   resultset.getInt("quantity"),
	                                   resultset.getInt("items_total")));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        close();
	    }
	    return oi;
	}
	
	@Override
	public ArrayList<Order_Items> fetch(Order_Items o) {
	    try {
	        pstmt = con.prepareStatement("SELECT * FROM orderitems WHERE order_id=?");
	        pstmt.setInt(1, o.getOrder_items_id());  // Correct parameter
	        resultset = pstmt.executeQuery();  // Assign resultset to the query result

	        while (resultset.next()) {
	            oi.add(new Order_Items(resultset.getInt("order_item_id"),
	                                   resultset.getInt("order_id"),
	                                   resultset.getInt("menu_id"),
	                                   resultset.getInt("quantity"),
	                                   resultset.getInt("items_total")));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return oi;
	}


	
	@Override
	public int update(Order_Items o) {
		try {
			pstmt=con.prepareStatement("Update orderitems set quantity=?,items_total=?");
			pstmt.setInt(1, o.getQuanttity());
			pstmt.setInt(2, o.getItems_total());
			
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
	public int delete(Order_Items o) {
		
		try {
			pstmt=con.prepareStatement("Delete FROM orderitems where user_id=?");
			pstmt.setInt(1, o.getOrder_items_id());
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
