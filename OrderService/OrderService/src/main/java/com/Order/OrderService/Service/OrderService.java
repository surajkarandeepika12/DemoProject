package com.Order.OrderService.Service;

import com.Order.OrderService.entity.Orders;
import com.Order.OrderService.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Map;
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;

    @Autowired public OrderService(OrderRepository orderRepository, RestTemplate restTemplate) { this.orderRepository = orderRepository; this.restTemplate = restTemplate; }

    public Orders Placeorder(Long productId, String productName, int quantity){
        restTemplate.postForObject("http://host.docker.internal:8081/inventory/update", Map.of("productId",productId,"quantity",quantity),String.class);

        Orders orders = new Orders();
        orders.setProductId(productId);
        orders.setProductName(productName);
        orders.setQuantity(quantity);
        orders.setStatus("Placed");
        orders.setOrderDate(LocalDate.now());
        return orderRepository.save(orders);
    }


}
