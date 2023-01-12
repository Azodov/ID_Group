package com.bogcha.application.service;

import com.bogcha.application.domain.order.Orders;
import com.bogcha.application.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Orders> findAll(){
        return orderRepository.findAll();
    }
}
