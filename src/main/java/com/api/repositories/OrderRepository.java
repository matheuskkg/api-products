package com.api.repositories;

import com.api.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("orderRepository")
public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findAllByCustomerId(Integer id);

}
