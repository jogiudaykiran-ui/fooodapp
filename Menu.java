package com.foodapp.model;

public class Menu {

	private int menu_id;
	private int Restaurant_id;
	private String name;
	private String description;
	private int price;
	private byte is_available;
	private String image_path;
	
	public Menu() {
		
	}

	public Menu(int menu_id, int restaurant_id, String name, String description, int price, byte is_available, String image_path) {
		super();
		this.menu_id = menu_id;
		this.Restaurant_id = restaurant_id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.is_available = is_available;
		this.image_path=image_path;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	public int getRestaurant_id() {
		return Restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id) {
		Restaurant_id = restaurant_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public byte getIs_available() {
		return is_available;
	}

	public void setIs_available(byte is_available) {
		this.is_available = is_available;
	}

	@Override
	public String toString() {
		return "Menu [menu_id=" + menu_id + ", Restaurant_id=" + Restaurant_id + ", name=" + name + ", description="
				+ description + ", price=" + price + ", is_available=" + is_available + ", image_path=" + image_path
				+ "]";
	}
	
	
	
	
}
