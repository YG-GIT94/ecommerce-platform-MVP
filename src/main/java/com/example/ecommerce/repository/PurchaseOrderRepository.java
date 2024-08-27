package com.example.ecommerce.repository; // Defines the package for this repository interface

import com.example.ecommerce.model.PurchaseOrder; // Imports the PurchaseOrder entity class
import org.springframework.data.jpa.repository.JpaRepository; // Imports the JpaRepository interface

/**
 * Repository interface for managing PurchaseOrder entities.
 * Extends JpaRepository to provide CRUD operations and custom query methods.
 */
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
    // This interface automatically inherits CRUD methods from JpaRepository
}
