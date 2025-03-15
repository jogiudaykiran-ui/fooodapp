package com.foodapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.dao.MenuInterface;
import com.foodapp.model.Menu;
import com.user.connect.Connect;

public class MenuImpl implements MenuInterface{
	
	ArrayList<Menu> menu=new ArrayList<Menu>();
	static Connection con;
	static{
		con = Connect.connect();
	}
	
	private static String fetchMenu="Select * from menu where Restaurant_id=?";
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultset;
	
	@Override
	public int insert(Menu m) {
		try {
			pstmt=con.prepareStatement("INSERT INTO menu(`menu_id`,`Restaurant_id`,`name`,`description`,`price`,`is_available`,`image_path`) VALUES (?, ?, ?, ?, ?,?,?);");
			pstmt.setInt(1, m.getMenu_id());
			pstmt.setInt(2,m.getRestaurant_id());
			pstmt.setString(3,m.getName());
			pstmt.setString(4, m.getDescription());
			pstmt.setInt(5, m.getPrice());
			pstmt.setByte(6, m.getIs_available());
			pstmt.setString(6, m.getImage_path());
			
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
	public ArrayList<Menu> fetchAll() {
		
		try {
			stmt=con.createStatement();
			resultset=stmt.executeQuery("Select * from menu");

			while(resultset.next()) {

			menu.add(new Menu(resultset.getInt("menu_id"),resultset.getInt("Restaurant_id"),resultset.getString("name"),resultset.getString("description"),resultset.getInt("price"),resultset.getByte("is_available"),resultset.getString("image_path")));

			}
			
			pstmt.executeQuery();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
		return menu;
	}
	
	@Override
	public Menu fetch(int ItemId) {
		try {
			pstmt=con.prepareStatement("Select * from menu where menu_id=?");
			pstmt.setInt(1,ItemId);
			resultset=pstmt.executeQuery();
			
			while(resultset.next()) {
				
				menu.add(new Menu(resultset.getInt("menu_id"),resultset.getInt("Restaurant_id"),resultset.getString("name"),resultset.getString("description"),resultset.getInt("price"),resultset.getByte("is_available"),resultset.getString("image_path")));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
//		finally {
//			close();
//		}
		return menu.get(0);
	}
	
	@Override
	public List<Menu> fetchMenuByRestaurant(int Restaurant_id) {
		try {
			
			pstmt=con.prepareStatement(fetchMenu);
			pstmt.setInt(1,Restaurant_id);
			resultset=pstmt.executeQuery();
			while(resultset.next()) {
				menu.add(new Menu(resultset.getInt("menu_id"),
						resultset.getInt("Restaurant_id"),
						resultset.getString("name"),
						resultset.getString("description"),
						resultset.getInt("price"),
						resultset.getByte("is_available"),
						resultset.getString("image_path")));
			}
		}
			
		catch(Exception e) {
			e.printStackTrace();
		}
		return menu;
	}
	
		


	
	@Override
	public int update(Menu m) {
		try {
			pstmt=con.prepareStatement("Update menu set Restaurant_id=?,name=?,description=?,price=?,is_available=? where menu_id=?");
			pstmt.setInt(1, m.getRestaurant_id() );
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getDescription());
			pstmt.setInt(4, m.getPrice());
			pstmt.setByte(5, m.getIs_available());
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
	public int delete(Menu m) {
		
		try {
			pstmt=con.prepareStatement("Delete FROM menu where menu_id=?");
			pstmt.setInt(1, m.getMenu_id());
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
	public List<Menu> searchMenu(String keyword) {
	    
	    try {
	        // Use a prepared statement with a LIKE clause for partial matching
	        String searchQuery = "SELECT * FROM menu WHERE name LIKE ? OR description LIKE ?";
	        System.out.println("from database");
	        pstmt = con.prepareStatement(searchQuery);
	        System.out.println("fetching from database");
	        
	        // Add wildcard '%' to search for partial matches
	        String searchKeyword = "%" + keyword + "%";
	        
	        pstmt.setString(1, searchKeyword);
	        pstmt.setString(2, searchKeyword);
	        
	        System.out.println("inserting into ?");
	        
	        resultset = pstmt.executeQuery();
	        
	        // Iterate over the results and add them to the searchResults list
	        while (resultset.next()) {
	            Menu menuItem = new Menu(
	                resultset.getInt("menu_id"),
	                resultset.getInt("Restaurant_id"),
	                resultset.getString("name"),
	                resultset.getString("description"),
	                resultset.getInt("price"),
	                resultset.getByte("is_available"),
	                resultset.getString("image_path")
	            );
	            menu.add(menuItem);
	            System.out.println(menu);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
	    return menu;
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
