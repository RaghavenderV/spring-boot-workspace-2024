package com.vodapally.command.api.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, String> {
}
