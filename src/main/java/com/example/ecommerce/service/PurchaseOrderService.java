package com.example.ecommerce.service;

import com.example.ecommerce.model.Customer;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.PurchaseOrder;
import com.example.ecommerce.model.ShoppingCart;
import com.example.ecommerce.repository.CustomerRepository;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.repository.PurchaseOrderRepository;
import com.example.ecommerce.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class PurchaseOrderService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Transactional
    public PurchaseOrder checkout(Long customerId) {
        ShoppingCart cart = shoppingCartRepository.findByCustomerCustomerId(customerId)
                .orElseThrow(() -> new RuntimeException("Shopping cart not found for customer: " + customerId));

        Map<Product, Integer> cartItems = cart.getProducts();
        if (cartItems.isEmpty()) {
            throw new RuntimeException("No items in the shopping cart for this customer");
        }

        PurchaseOrder purchaseOrder = new PurchaseOrder();
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found: " + customerId));
        purchaseOrder.setCustomer(customer);
        purchaseOrder.setProducts(cartItems);

        double totalAmount = cartItems.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
        purchaseOrder.setTotalAmount(totalAmount);

        PurchaseOrder savedOrder = purchaseOrderRepository.save(purchaseOrder);

        cart.clearProducts();
        shoppingCartRepository.save(cart);

        return savedOrder;
    }

    @Transactional
    public PurchaseOrder singleItemCheckout(Long customerId, Long productId, int quantity) {
        ShoppingCart cart = shoppingCartRepository.findByCustomerCustomerId(customerId)
                .orElseThrow(() -> new RuntimeException("Shopping cart not found for customer: " + customerId));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found: " + productId));

        cart.addProduct(product, quantity);
        shoppingCartRepository.save(cart);

        return checkout(customerId);
    }

    @Transactional
    public PurchaseOrder getPurchaseOrderById(Long id) {
        return purchaseOrderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase order not found: " + id));
    }

    @Transactional
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseOrderRepository.findAll();
    }
}
