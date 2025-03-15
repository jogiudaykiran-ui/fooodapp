package com.foodapp.controller;  // Ensure this matches the servlet's package

import java.util.HashMap;
import java.util.Map;

import com.foodapp.model.CartItems;

public class Cart {
    private Map<Integer, CartItems> items = new HashMap<>();

    // Add an item to the cart
    public void addItems(CartItems cartItem) {
        items.put(cartItem.getItemId(), cartItem);
    }

    // Get an item by its itemId
    public CartItems getItem(int itemId) {
        return items.get(itemId);
    }

    // Remove an item from the cart
    public void removeitem(int itemId) {
        items.remove(itemId);
    }

    // Get all items in the cart
    public Map<Integer, CartItems> getallitems() {
        return items;
    }
}
