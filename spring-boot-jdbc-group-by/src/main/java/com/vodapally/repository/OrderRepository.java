package com.vodapally.repository;

import com.vodapally.model.CustomerOrderSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {
    @Autowired
    private JdbcClient jdbcClient;

    public List<CustomerOrderSummary> getCustomerOrderSummaries(){
        String sql = "SELECT CUSTOMER_ID, SUM(AMOUNT) AS TOTAL_AMOUNT FROM VODAPALLY_DS1.ORDERS GROUP BY CUSTOMER_ID";
        return jdbcClient.sql(sql)
                .query((rs, rowNum) -> {
                    CustomerOrderSummary summary = new CustomerOrderSummary();
                    summary.setCustomerId(rs.getInt("CUSTOMER_ID"));
                    summary.setTotalAmount(rs.getInt("TOTAL_AMOUNT"));
                    return summary;
                })
                .list();
    }
}
/*
Use JdbcClient to execute the GROUP BY query
and map the results to the CustomerOrderSummary class.
 */

/* group by using jpa -- write below in repository
@Query("SELECT new com.vodapally.dto.SalesSummary(s.productCategory, SUM(s.amount)) from Sales s GROUP BY s.productCategory")
    List<SalesSummary> getSalesSummaryByCategory();
 */