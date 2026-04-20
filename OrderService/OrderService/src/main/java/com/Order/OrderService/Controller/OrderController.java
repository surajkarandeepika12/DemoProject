package com.Order.OrderService.Controller;

import com.Order.OrderService.Service.OrderService;
import com.Order.OrderService.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/place")
    public Orders placeOrder(@RequestParam Long productId,
                             @RequestParam String productName,
                             @RequestParam int quantity) {
        return orderService.Placeorder(productId,productName, quantity);
    }
}
