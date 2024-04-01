package com.example.order.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.order.entity.Order;

public interface OrderRepo extends MongoRepository<Order, Integer> {

}
