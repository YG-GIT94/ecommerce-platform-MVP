package com.example.ecommerce.service;

import com.example.ecommerce.model.ShoppingCartItem;
import com.example.ecommerce.repository.ShoppingCartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartItemService {

    @Autowired
    private ShoppingCartItemRepository shoppingCartItemRepository;

    public ShoppingCartItem saveItem(ShoppingCartItem shoppingCartItem) {
        return shoppingCartItemRepository.save(shoppingCartItem);
    }

    public ShoppingCartItem getItemById(Long id) {
        return shoppingCartItemRepository.findById(id).orElse(null);
    }

    public List<ShoppingCartItem> getAllItems() {
        return shoppingCartItemRepository.findAll();
    }
}
