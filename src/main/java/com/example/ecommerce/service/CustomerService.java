package com.example.ecommerce.service;

import com.example.ecommerce.model.Customer;
import com.example.ecommerce.model.ShoppingCart;
import com.example.ecommerce.repository.CustomerRepository;
import com.example.ecommerce.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Transactional
    public Customer createCustomer(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);

        // Create a shopping cart for the new customer
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCustomer(savedCustomer);
        shoppingCartRepository.save(shoppingCart);

        return savedCustomer;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
