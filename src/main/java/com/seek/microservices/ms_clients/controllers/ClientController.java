package com.seek.microservices.ms_clients.controllers;

import com.seek.microservices.ms_clients.domain.dto.ClientRequest;
import com.seek.microservices.ms_clients.domain.entities.Client;
import com.seek.microservices.ms_clients.services.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/clients")
@RequiredArgsConstructor
@Tag(name = "Clientes", description = "Manejo de clientes en el sistema")
@SecurityRequirement(name = "bearerAuth")
public class ClientController {

    private final ClientService service;

    @Operation(summary = "Obtener todos los clientes", description = "Obtiene todos los clientes con sus datos completos y cálculo estimado de esperanza de vida")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de clientes obtenida"),
            @ApiResponse(responseCode = "500", description = "Error del servidor")
    })
    @GetMapping
    public ResponseEntity<?> getClients() {
        return ResponseEntity.ok(service.findAll());
    }

    @Operation(summary = "Crear un nuevo cliente", description = "Registra un cliente con nombre, apellido, edad y fecha de nacimiento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos"),
            @ApiResponse(responseCode = "500", description = "Error interno")
    })
    @PostMapping
    public ResponseEntity<?> createClient(@Valid @RequestBody ClientRequest request) {
        Client saved = service.create(request);
        return ResponseEntity.ok(saved);
    }

    @Operation(summary = "Métricas de clientes", description = "Devuelve el promedio y la desviación estándar de la edad de los clientes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Métricas calculadas correctamente"),
            @ApiResponse(responseCode = "500", description = "Error al calcular métricas")
    })
    @GetMapping("/metrics")
    public ResponseEntity<?> getClientMetrics() {
        return ResponseEntity.ok(service.getMetrics());
    }
}
