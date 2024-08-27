package com.example.ecommerce.model;

import jakarta.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Customer customer;

    @ElementCollection
    @CollectionTable(name = "shopping_cart_products", joinColumns = @JoinColumn(name = "cart_id"))
    @MapKeyJoinColumn(name = "product_id")
    @Column(name = "quantity")
    private Map<Product, Integer> products = new HashMap<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    // Add a product to the cart
    public void addProduct(Product product, int quantity) {
        products.merge(product, quantity, Integer::sum);
    }

    // Clear all products from the cart
    public void clearProducts() {
        products.clear();
    }
}
