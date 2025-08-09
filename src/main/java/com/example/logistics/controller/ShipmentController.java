package com.example.logistics.controller;

import com.example.logistics.model.Shipment;
import com.example.logistics.service.ShipmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {
    private final ShipmentService service;

    public ShipmentController(ShipmentService service) {
        this.service = service;
    }

    @PostMapping
    public Shipment create(@RequestBody Shipment shipment) {
        return service.createShipment(shipment);
    }

    @GetMapping
    public List<Shipment> getAll() {
        return service.getAllShipments();
    }

    @GetMapping("/track/{trackingId}")
    public Shipment getByTracking(@PathVariable String trackingId) {
        return service.getByTrackingId(trackingId);
    }

    @PutMapping("/{id}")
    public Shipment updateStatus(@PathVariable Long id, @RequestParam String status) {
        return service.updateStatus(id, status);
    }
}
