package com.springboot.graphql.graphqlDemo.repositories;

import com.springboot.graphql.graphqlDemo.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
