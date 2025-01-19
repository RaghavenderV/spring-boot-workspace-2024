package com.vodapally.spring_transaction.repository;

import com.vodapally.spring_transaction.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
