package com.foodapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.foodapp.dao.UserInterface;
import com.foodapp.model.User;
import com.user.connect.Connect;;

public class UserImpl implements UserInterface{

	ArrayList<User> userList=new ArrayList<User>();
	static Connection con;
	static{
		con = Connect.connect();
	}

	private PreparedStatement pstmt;
	private ResultSet resultset;
	private Statement stmt;
	
//	public String encrypt(String str) {
//
//		StringBuffer sb=new StringBuffer();
//		for(int i=0;i<str.length();i++) {
//			sb.append((char)(str.charAt(i)+2));
//		}
//		return sb.toString();
//	}
//
//	public String decrypt(String string) {
//
//		StringBuffer sb=new StringBuffer();
//		for(int i=0;i<string.length();i++) {
//			sb.append((char)(string.charAt(i)-2));
//		}
//		return sb.toString();
//	}
	
	@Override
	public int insert(User u) {
		
		try {
			pstmt=con.prepareStatement("INSERT INTO user(`user_name`, `password`, `email`, `adress`) VALUES (?, ?, ?, ?);");
			pstmt.setString(1, u.getUser_name());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, u.getEmail());
			pstmt.setString(4, u.getAdress());
			
			return pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
//		finally {
//			close();
//		}
		return 0;
	}
	
	@Override
	public ArrayList<User> fetchAll() {
		try {
			stmt=con.createStatement();
			resultset=stmt.executeQuery("Select * from user");
			
			while(resultset.next()) {
				
				userList.add(new User(resultset.getInt("user_id"),resultset.getString("user_name"),resultset.getString("password"),resultset.getString("email"),resultset.getString("adress")));
				
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
//		finally {
//			close();
//		}
		return userList;
	}
	
	@Override
	public ArrayList<User> fetch(User u) {
		
		try {
			pstmt=con.prepareStatement("SELECT * FROM user WHERE email = ?");
			pstmt.setString(1, u.getEmail());
			resultset=pstmt.executeQuery();
			
			while(resultset.next()) {
				
				userList.add(new User(resultset.getInt("user_id"),resultset.getString("user_name"),resultset.getString("password"),resultset.getString("email"),resultset.getString("adress")));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
//		finally {
//			close();
//		}
		return userList;
	}
	
	@Override
	public int update(String password, String email) {
		
		try {
			pstmt=con.prepareStatement("Update user set password=? where email=?");
			pstmt.setString(1, password);
			pstmt.setString(2, email);
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
//		finally {
//			close();
//		}
		return 0;
	}
	
	@Override
	public int delete(User u) {
			
		try {
			pstmt=con.prepareStatement("Delete FROM user where user_id=?");
			pstmt.setInt(1, u.getUser_id());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		finally {
//			close();
//		}
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
