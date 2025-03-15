package com.foodapp.model;

public class Restaurent {

	private int Restaurant_id;
	private String Restaurant_name;
	private String Cuisine_type;
	private int Delivery_time;
	private String Restaurant_adress;
	private float Restaurant_rating;
	private int Restaurant_isActive;
	private String Restauran_imagePath;
	
	public Restaurent() {
		super();
	}

	public Restaurent(int restaurant_id, String restaurant_name, String cuisine_type, int delivery_time,
			String restaurant_adress, float restaurant_rating, int restaurant_isActive,
			String restauran_imagePath) {
		super();
		Restaurant_id = restaurant_id;
		Restaurant_name = restaurant_name;
		Cuisine_type = cuisine_type;
		Delivery_time = delivery_time;
		Restaurant_adress = restaurant_adress;
		Restaurant_rating = restaurant_rating;
		Restaurant_isActive = restaurant_isActive;
		Restauran_imagePath = restauran_imagePath;
	}

	public int getRestaurant_id() {
		return Restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id) {
		Restaurant_id = restaurant_id;
	}

	public String getRestaurant_name() {
		return Restaurant_name;
	}

	public void setRestaurant_name(String restaurant_name) {
		Restaurant_name = restaurant_name;
	}

	public String getCuisine_type() {
		return Cuisine_type;
	}

	public void setCuisine_type(String cuisine_type) {
		Cuisine_type = cuisine_type;
	}

	public int getDelivery_time() {
		return Delivery_time;
	}

	public void setDelivery_time(int delivery_time) {
		Delivery_time = delivery_time;
	}

	public String getRestaurant_adress() {
		return Restaurant_adress;
	}

	public void setRestaurant_adress(String restaurant_adress) {
		Restaurant_adress = restaurant_adress;
	}

	public float getRestaurant_rating() {
		return Restaurant_rating;
	}

	public void setRestaurant_rating(float restaurant_rating) {
		Restaurant_rating = restaurant_rating;
	}

	public int getRestaurant_isActive() {
		return Restaurant_isActive;
	}

	public void setRestaurant_isActive(int restaurant_isActive) {
		Restaurant_isActive = restaurant_isActive;
	}

	public String getRestauran_imagePath() {
		return Restauran_imagePath;
	}

	public void setRestauran_imagePath(String restauran_imagePath) {
		Restauran_imagePath = restauran_imagePath;
	}

	@Override
	public String toString() {
		return "Restaurent [Restaurant_id=" + Restaurant_id + ", Restaurant_name=" + Restaurant_name + ", Cuisine_type="
				+ Cuisine_type + ", Delivery_time=" + Delivery_time + ", Restaurant_adress=" + Restaurant_adress
				+ ", Restaurant_rating=" + Restaurant_rating + ", Restaurant_isActive=" + Restaurant_isActive
				+ ", Restauran_imagePath=" + Restauran_imagePath + "]";
	}
	
	
}
