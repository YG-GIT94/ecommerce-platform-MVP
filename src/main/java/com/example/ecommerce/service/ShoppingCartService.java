package com.example.ecommerce.service;

import com.example.ecommerce.model.Customer;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.ShoppingCart;
import com.example.ecommerce.repository.CustomerRepository;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public ShoppingCart getCartByCustomerId(Long customerId) {
        return shoppingCartRepository.findByCustomerCustomerId(customerId)
                .orElseThrow(() -> new RuntimeException("Shopping cart not found for customer: " + customerId));
    }

    @Transactional
    public ShoppingCart addProductToCart(Long customerId, Long productId, int quantity) {
        ShoppingCart cart = getCartByCustomerId(customerId);

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found: " + productId));

        cart.getProducts().put(product, cart.getProducts().getOrDefault(product, 0) + quantity);
        return shoppingCartRepository.save(cart);
    }

    @Transactional
    public void clearCart(Long customerId) {
        ShoppingCart cart = getCartByCustomerId(customerId);
        cart.getProducts().clear();
        shoppingCartRepository.save(cart);
    }
}
