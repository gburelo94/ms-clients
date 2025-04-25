package com.seek.microservices.ms_clients.services;


import com.seek.microservices.ms_clients.domain.dto.ClientMetricsResponse;
import com.seek.microservices.ms_clients.domain.dto.ClientRequest;
import com.seek.microservices.ms_clients.domain.dto.ClientResponse;
import com.seek.microservices.ms_clients.domain.entities.Client;

import java.util.List;

public interface ClientService {

    List<ClientResponse> findAll();

    Client create(ClientRequest request);

    ClientMetricsResponse getMetrics();
}
