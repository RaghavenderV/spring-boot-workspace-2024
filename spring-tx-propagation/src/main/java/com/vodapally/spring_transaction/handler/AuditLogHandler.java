package com.vodapally.spring_transaction.handler;

import com.vodapally.spring_transaction.entity.AuditLog;
import com.vodapally.spring_transaction.entity.Order;
import com.vodapally.spring_transaction.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component
public class AuditLogHandler {

    @Autowired
    private AuditLogRepository auditLogRepository;

    // Log audit details (runs in an independent transaction)
    //@Transactional(propagation = Propagation.REQUIRES_NEW)
    public void logAuditDetails(Order order, String action) {
        AuditLog auditLog = new AuditLog();
        auditLog.setOrderId(Long.valueOf(order.getId()));
        auditLog.setAction(action);
        auditLog.setTimestamp(LocalDateTime.now());

        // Save the audit log
        auditLogRepository.save(auditLog);
    }
}
