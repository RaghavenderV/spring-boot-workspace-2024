package com.vodapally.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrderSummary {
    private int customerId;
    private int totalAmount;
}
/*
Create a model class to represent the result of the query.
 */