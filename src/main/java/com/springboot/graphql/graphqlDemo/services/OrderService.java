package com.springboot.graphql.graphqlDemo.services;

import com.springboot.graphql.graphqlDemo.entities.Order;
import com.springboot.graphql.graphqlDemo.repositories.OrderRepository;
import com.springboot.graphql.graphqlDemo.utils.ExceptionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    
    private final OrderRepository orderRepository;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getOrder() {
        return orderRepository.findAll();
    }

    public Order findOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> ExceptionHandler.throwResourceNotFound(id, "Order"));
    }

    public Boolean deleteOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> ExceptionHandler.throwResourceNotFound(id, "Order"));
        orderRepository.delete(order);
        return true;
    }
}
