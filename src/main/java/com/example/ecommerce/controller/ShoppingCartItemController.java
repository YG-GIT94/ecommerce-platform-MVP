package com.example.ecommerce.controller;

import com.example.ecommerce.model.ShoppingCartItem;
import com.example.ecommerce.service.ShoppingCartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartItemController {

    @Autowired
    private ShoppingCartItemService shoppingCartItemService;

    @PostMapping
    public ResponseEntity<ShoppingCartItem> addItemToCart(@RequestBody ShoppingCartItem shoppingCartItem) {
        ShoppingCartItem savedItem = shoppingCartItemService.saveItem(shoppingCartItem);
        return ResponseEntity.ok(savedItem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingCartItem> getItemById(@PathVariable Long id) {
        ShoppingCartItem item = shoppingCartItemService.getItemById(id);
        return ResponseEntity.ok(item);
    }

    @GetMapping
    public ResponseEntity<List<ShoppingCartItem>> getAllItems() {
        List<ShoppingCartItem> items = shoppingCartItemService.getAllItems();
        return ResponseEntity.ok(items);
    }
}
