package com.example.ecommerce.dto;

import com.example.ecommerce.model.ShoppingCart;
import java.util.List;

public class CheckoutRequestDTO {
    private Long customerId;
    private List<ShoppingCart> cartItems;

    // Getters and setters
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<ShoppingCart> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<ShoppingCart> cartItems) {
        this.cartItems = cartItems;
    }
}
