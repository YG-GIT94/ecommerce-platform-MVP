package com.example.ecommerce.controller;

import com.example.ecommerce.dto.SingleItemCheckoutDTO;
import com.example.ecommerce.model.PurchaseOrder;
import com.example.ecommerce.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchaseorders")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @PostMapping("/checkout")
    public PurchaseOrder checkout(@RequestParam Long customerId) {
        return purchaseOrderService.checkout(customerId);
    }

    @PostMapping("/checkout/single")
    public PurchaseOrder singleItemCheckout(@RequestBody SingleItemCheckoutDTO singleItemCheckoutDTO) {
        return purchaseOrderService.singleItemCheckout(
                singleItemCheckoutDTO.getCustomerId(),
                singleItemCheckoutDTO.getProductId(),
                singleItemCheckoutDTO.getQuantity()
        );
    }

    @GetMapping("/{id}")
    public PurchaseOrder getPurchaseOrderById(@PathVariable Long id) {
        return purchaseOrderService.getPurchaseOrderById(id);
    }

    @GetMapping
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseOrderService.getAllPurchaseOrders();
    }
}
