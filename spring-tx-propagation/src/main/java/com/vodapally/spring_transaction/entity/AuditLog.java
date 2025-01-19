package com.vodapally.spring_transaction.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "AUDITLOG_TX")
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;  // The order associated with the log

    private String action;  // Action taken (e.g., "Order Placed", "Payment Failed")

    private LocalDateTime timestamp;  // Timestamp of the action

    // Default constructor
    public AuditLog() {
        this.timestamp = LocalDateTime.now();  // Default timestamp is the current time
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
