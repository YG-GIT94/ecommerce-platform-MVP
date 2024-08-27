package com.example.ecommerce.controller;

import com.example.ecommerce.dto.ShoppingCartRequestDTO;
import com.example.ecommerce.model.ShoppingCart;
import com.example.ecommerce.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping
    public ShoppingCart getShoppingCartByCustomerId(@RequestParam Long customerId) {
        return shoppingCartService.getCartByCustomerId(customerId);
    }

    @PostMapping("/add")
    public ShoppingCart addProductToCart(@RequestBody ShoppingCartRequestDTO shoppingCartRequestDTO) {
        return shoppingCartService.addProductToCart(
                shoppingCartRequestDTO.getCustomerId(),
                shoppingCartRequestDTO.getProductId(),
                shoppingCartRequestDTO.getQuantity()
        );
    }

    @PostMapping("/clear")
    public void clearCart(@RequestBody ShoppingCartRequestDTO shoppingCartRequestDTO) {
        shoppingCartService.clearCart(shoppingCartRequestDTO.getCustomerId());
    }
}
