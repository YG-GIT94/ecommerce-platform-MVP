package com.example.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ecommerce.model.Customer;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Customer entities.
 * Extends JpaRepository to provide CRUD operations and custom query methods.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // This interface automatically inherits CRUD methods from JpaRepository
}
