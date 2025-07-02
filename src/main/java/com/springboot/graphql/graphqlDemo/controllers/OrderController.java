package com.springboot.graphql.graphqlDemo.controllers;

import com.springboot.graphql.graphqlDemo.entities.Order;
import com.springboot.graphql.graphqlDemo.entities.User;
import com.springboot.graphql.graphqlDemo.services.OrderService;
import com.springboot.graphql.graphqlDemo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final UserService userService;
    private final OrderService orderService;

    @MutationMapping
    public Order createOrder(@Argument String orderDetail, @Argument String address,
                             @Argument Long price, @Argument Long userId) {

        User user = userService.findUserById(userId);
        Order order = new Order();
        order.setOrderDetail(orderDetail);
        order.setPrice(price);
        order.setAddress(address);
        order.setUser(user);

        return orderService.createOrder(order);
    }

    @QueryMapping
    public List<Order> getOrders() {
        return orderService.getOrder();
    }

    @QueryMapping
    public Order getOrder(@Argument Long orderId) {
        return orderService.findOrderById(orderId);
    }

    @MutationMapping
    public Boolean deleteOrder(@Argument Long orderId) {
        return orderService.deleteOrderById(orderId);
    }
}
