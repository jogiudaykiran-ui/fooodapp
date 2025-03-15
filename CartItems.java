package com.foodapp.model;

public class CartItems {

	private int itemId;
	private int Resataurant_id;
	private String name;
	private int price;
	private int quantity;
	
	

	public CartItems() {
		
	}
	
	public CartItems(int itemId, int resataurant_id, String name, int price, int quantity) {
		super();
		this.itemId = itemId;
		this.Resataurant_id = resataurant_id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	

	public int getItemId() {
		return itemId;
	}
	public void setItemId(int menuId) {
		this.itemId = menuId;
	}
	public int getResataurant_id() {
		return Resataurant_id;
	}
	public void setResataurant_id(int resataurant_id) {
		Resataurant_id = resataurant_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "CartItems [itemId=" + itemId + ", Resataurant_id=" + Resataurant_id + ", name=" + name + ", price="
				+ price + ", quantity=" + quantity + "]";
	}
	
}
