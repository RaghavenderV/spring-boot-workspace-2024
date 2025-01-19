package com.vodapally.repositry;

import com.vodapally.dto.CustomerOrderDTO;
import com.vodapally.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query(value = "SELECT NEW com.vodapally.dto.CustomerOrderDTO(c.name, COUNT(o), SUM(o.price)) FROM Customer c JOIN c.orders o GROUP BY c.id")
    List<CustomerOrderDTO> findCustomerNameWithOrderCount();
}
