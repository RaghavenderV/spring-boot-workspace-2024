package com.vodapally.repository;

import com.vodapally.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Procedure(name = "updateStockProcedure")
    void updateStock(Integer productId, Integer quantity);

    @Query(value = "SELECT get_total_price(:productId)", nativeQuery = true)
    Double getTotalPriceForProduct(Integer productId);
}
