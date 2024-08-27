package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing Product entities.
 * Provides business logic and operations related to products.
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Retrieves all product entities from the database.
     *
     * @return a list of all product entities
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Retrieves a product entity by its ID.
     *
     * @param id the ID of the product to be retrieved
     * @return the product entity, or null if not found
     */
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    /**
     * Creates a new product entity in the database.
     *
     * @param product the product entity to be created
     * @return the created product entity
     */
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Creates multiple product entities in the database.
     *
     * @param products the list of product entities to be created
     * @return the list of created product entities
     */
    public List<Product> createProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    /**
     * Updates an existing product entity in the database.
     *
     * @param id the ID of the product to be updated
     * @param product the updated product entity
     * @return the updated product entity, or null if the product does not exist
     */
    public Product updateProduct(Long id, Product product) {
        if (productRepository.existsById(id)) {
            product.setProductId(id);
            return productRepository.save(product);
        }
        return null;
    }

    /**
     * Deletes a product entity by its ID.
     *
     * @param id the ID of the product to be deleted
     */
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
