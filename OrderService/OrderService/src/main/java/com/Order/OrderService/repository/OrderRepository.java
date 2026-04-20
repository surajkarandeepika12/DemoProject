package com.Order.OrderService.repository;

import com.Order.OrderService.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> {


}
