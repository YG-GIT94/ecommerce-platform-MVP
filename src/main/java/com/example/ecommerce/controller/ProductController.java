package com.example.ecommerce.controller;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing products.
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Create a new product.
     * @param product The product to create.
     * @return The created product.
     */
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    /**
     * Create multiple products in one request.
     * @param products The list of products to create.
     * @return The list of created products.
     */
    @PostMapping("/bulk")
    public List<Product> createProducts(@RequestBody List<Product> products) {
        return productService.createProducts(products);
    }

    /**
     * Get a product by its ID.
     * @param id The ID of the product.
     * @return The product with the specified ID.
     */
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    /**
     * Get all products.
     * @return The list of all products.
     */
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * Update a product by its ID.
     * @param id The ID of the product to update.
     * @param product The updated product details.
     * @return The updated product, or null if the product doesn't exist.
     */
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    /**
     * Delete a product by its ID.
     * @param id The ID of the product to delete.
     */
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
