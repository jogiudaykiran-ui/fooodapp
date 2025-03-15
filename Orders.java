package com.foodapp.model;

import java.util.ArrayList;

public class Orders {

    private int order_id;
    private double total_amount;
    private String status;
    private String payment_mode;
    private int user_id;
    private int Restaurant_id; // Corrected spelling
    private ArrayList<Order_Items> orderItems; // Add this field to store the order items

    // Add getter and setter for orderItems
    public ArrayList<Order_Items> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ArrayList<Order_Items> orderItems) {
        this.orderItems = orderItems;
    }

    public Orders() {
    }

    public Orders(int order_id, double total_amount, String status, String payment_mode, int user_id,
                  int Restaurant_id) {
        super();
        this.order_id = order_id;
        this.total_amount = total_amount;
        this.status = status;
        this.payment_mode = payment_mode;
        this.user_id = user_id;
        this.Restaurant_id = Restaurant_id; // Corrected spelling
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPayment_mode() {
        return payment_mode;
    }

    public void setPayment_mode(String payment_mode) {
        this.payment_mode = payment_mode;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRestaurant_id() { // Corrected getter name
        return Restaurant_id;
    }

    public void setRestaurant_id(int Restaurant_id) { // Corrected setter name
        this.Restaurant_id = Restaurant_id;
    }

    @Override
    public String toString() {
        return "Orders [order_id=" + order_id + ", total_amount=" + total_amount + ", status=" + status
                + ", payment_mode=" + payment_mode + ", user_id=" + user_id + ", Restaurant_id=" + Restaurant_id + "]";
    }
}
