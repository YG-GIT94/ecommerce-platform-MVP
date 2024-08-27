package com.example.ecommerce.repository;

import com.example.ecommerce.model.Customer;
import com.example.ecommerce.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    Optional<ShoppingCart> findByCustomerCustomerId(Long customerId);

    // Remove the complex query and rely on business logic instead
}
