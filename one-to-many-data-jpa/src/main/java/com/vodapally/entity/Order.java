package com.vodapally.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    private int id;

    private String name;

    private int qty;

    private double price;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
