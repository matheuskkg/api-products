package com.api.services;

import com.api.dtos.response.OrderResponse;
import com.api.entities.Order;
import com.api.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("orderService")
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void save(Order order) {
        orderRepository.save(order);
    }

    private List<OrderResponse> getResponse(List<Order> orders) {
        return orders.stream().map(Order::buildResponse).collect(Collectors.toList());
    }

    public List<OrderResponse> findAll() {
        return getResponse(orderRepository.findAll());
    }

    public List<OrderResponse> findAllByCustomerId(Integer id) {
        return getResponse(orderRepository.findAllByCustomerId(id));
    }
}
