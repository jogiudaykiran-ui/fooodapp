package com.foodapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.foodapp.dao.Orders_history_interface;
import com.foodapp.model.Orders_History;
import com.user.connect.Connect;

public class Orders_History_impl implements Orders_history_interface{

	ArrayList<Orders_History> oh=new ArrayList<Orders_History>();
	static Connection con;
	static{
		con = Connect.connect();
	}

	private PreparedStatement pstmt;
	private ResultSet resultset;
	private Statement stmt;

	@Override
	public int insert(Orders_History o) {
		try {
			pstmt=con.prepareStatement("INSERT INTO order_history(`order_history_id`, `order_id`, `user_id`, `total_amount`,`status`) VALUES (?, ?, ?, ?,?);");
			pstmt.setInt(1, o.getOrder_history_id());
			pstmt.setInt(2,o.getOrder_id());
			pstmt.setInt(3, o.getUser_id());
			pstmt.setFloat(4, o.getTotal_amount());
			pstmt.setString(5, o.getStatus());

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
	public ArrayList<Orders_History> fetchAll() {
		try {
			stmt=con.createStatement();
			resultset=stmt.executeQuery("Select * from orders_history");

			while(resultset.next()) {

				oh.add(new Orders_History(resultset.getInt("order_history_id"),resultset.getInt("order_id"),resultset.getInt("user_id"),resultset.getFloat("total_amount"),resultset.getString("status"),resultset.getString("oredr_time")));

			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
		return oh;
	}

	@Override
	public ArrayList<Orders_History> fetch(Orders_History o){

		try {
			pstmt=con.prepareStatement("Select * from orders_history where order_history_id=?");
			pstmt.setInt(1, o.getOrder_history_id());
			resultset=pstmt.executeQuery();

			while(resultset.next()) {

				oh.add(new Orders_History(resultset.getInt("order_history_id"),resultset.getInt("order_id"),resultset.getInt("user_id"),resultset.getFloat("total_amount"),resultset.getString("status"),resultset.getString("oredr_time")));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
		return oh;
	}

	@Override
	public int update(Orders_History o) {

		try {
			pstmt=con.prepareStatement("Update orders_history set total_amount=?,status=?");
			pstmt.setFloat(1, o.getTotal_amount());
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
	public int delete(Orders_History o) {

		try {
			pstmt=con.prepareStatement("Delete FROM orders_history where orders_history_id=?");
			pstmt.setInt(1, o.getOrder_history_id());
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
