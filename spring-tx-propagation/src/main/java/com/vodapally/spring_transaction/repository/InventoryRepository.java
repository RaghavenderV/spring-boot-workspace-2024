package com.vodapally.spring_transaction.repository;

import com.vodapally.spring_transaction.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Product,Integer> {
}
