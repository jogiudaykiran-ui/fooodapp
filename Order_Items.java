package com.foodapp.model;

public class Order_Items {

	private int order_item_id;
	private int order_id;
	private int menu_id;
	private int quanttity;
	private int items_total;
	
	public Order_Items(){};
	
	public Order_Items(int order_items_id, int order_id, int menu_id, int quanttity, int items_total) {
		super();
		this.order_item_id = order_items_id;
		this.order_id = order_id;
		this.menu_id = menu_id;
		this.quanttity = quanttity;
		this.items_total = items_total;
	}
	
	public Order_Items( int order_id, int menu_id, int quanttity, int items_total) {
		super();
		this.order_id = order_id;
		this.menu_id = menu_id;
		this.quanttity = quanttity;
		this.items_total = items_total;
	}




	public int getOrder_items_id() {
		return order_item_id;
	}
	public void setOrder_items_id(int order_items_id) {
		this.order_item_id = order_items_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public int getQuanttity() {
		return quanttity;
	}
	public void setQuanttity(int quanttity) {
		this.quanttity = quanttity;
	}
	public int getItems_total() {
		return items_total;
	}
	public void setItems_total(int items_total) {
		this.items_total = items_total;
	}

	@Override
	public String toString() {
		return "Order_Items [order_items_id=" + order_item_id + ", order_id=" + order_id + ", menu_id=" + menu_id
				+ ", quanttity=" + quanttity + ", items_total=" + items_total + "]";
	}
	
	
	
	
}
