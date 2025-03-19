package com.vodapally.repository;

import com.vodapally.dto.SalesSummary;
import com.vodapally.entity.Sales;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {

    @QueryHints(@QueryHint(name = "org.hibernate.annotations.QueryHints.CACHEABLE", value = "true"))
    @Query("SELECT new com.vodapally.dto.SalesSummary(s.productCategory, SUM(s.amount)) from Sales s GROUP BY s.productCategory")
    List<SalesSummary> getSalesSummaryByCategory();
}
/*
The org.hibernate.annotations.QueryHints.CACHEABLE hint enables caching for this query.
Query Hints in JPA are used to provide additional instructions or hints to the JPA provider (e.g., Hibernate) when executing a query.
These hints can influence how the query is executed, such as enabling caching, setting timeouts, or controlling fetch behavior.
 */