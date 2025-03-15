package com.foodapp.model;

public class Orders_History {

	private int order_history_id;
	private int order_id;
	private int user_id;
	private float total_amount;
	private String status;
	private String order_time;
	
	
	public Orders_History() {
		super();
	}


	public Orders_History(int order_history_id, int order_id, int user_id, float total_amount, String status,
			String order_time) {
		super();
		this.order_history_id = order_history_id;
		this.order_id = order_id;
		this.user_id = user_id;
		this.total_amount = total_amount;
		this.status = status;
		this.order_time = order_time;
	}


	public int getOrder_history_id() {
		return order_history_id;
	}


	public void setOrder_history_id(int order_history_id) {
		this.order_history_id = order_history_id;
	}


	public int getOrder_id() {
		return order_id;
	}


	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public float getTotal_amount() {
		return total_amount;
	}


	public void setTotal_amount(float total_amount) {
		this.total_amount = total_amount;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getOrder_dime() {
		return order_time;
	}


	public void setOrder_dime(String order_dime) {
		this.order_time = order_dime;
	}


	@Override
	public String toString() {
		return "Orders_History [order_history_id=" + order_history_id + ", order_id=" + order_id + ", user_id="
				+ user_id + ", total_amount=" + total_amount + ", status=" + status + ", order_dime=" + order_time
				+ "]";
	}
	
	
}
