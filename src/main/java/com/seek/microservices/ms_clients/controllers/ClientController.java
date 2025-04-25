package com.seek.microservices.ms_clients.controllers;

import com.seek.microservices.ms_clients.domain.dto.ClientRequest;
import com.seek.microservices.ms_clients.domain.entities.Client;
import com.seek.microservices.ms_clients.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;

    @GetMapping
    public ResponseEntity<?> getClients() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<?> createClient(@RequestBody ClientRequest request) {
        Client saved = service.create(request);
        return ResponseEntity.ok(saved);
    }
}
