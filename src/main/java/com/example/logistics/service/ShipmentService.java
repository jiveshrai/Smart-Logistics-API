package com.example.logistics.service;

import com.example.logistics.model.Shipment;
import com.example.logistics.repository.ShipmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShipmentService {
    private final ShipmentRepository repo;

    public ShipmentService(ShipmentRepository repo) {
        this.repo = repo;
    }

    public Shipment createShipment(Shipment shipment) {
        return repo.save(shipment);
    }

    public List<Shipment> getAllShipments() {
        return repo.findAll();
    }

    public Shipment updateStatus(Long id, String status) {
        Shipment shipment = repo.findById(id).orElseThrow();
        shipment.setStatus(status);
        return repo.save(shipment);
    }

    public Shipment getByTrackingId(String trackingId) {
        return repo.findByTrackingId(trackingId).orElseThrow();
    }
}
