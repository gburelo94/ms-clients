package com.seek.microservices.ms_clients.services;


import com.seek.microservices.ms_clients.domain.dto.ClientRequest;
import com.seek.microservices.ms_clients.domain.entities.Client;

import java.util.List;

public interface ClientService {

    List<Client> findAll();

    Client create(ClientRequest request);
}
