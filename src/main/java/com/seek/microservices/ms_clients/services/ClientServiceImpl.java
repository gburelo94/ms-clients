package com.seek.microservices.ms_clients.services;

import com.seek.microservices.ms_clients.domain.dto.ClientRequest;
import com.seek.microservices.ms_clients.domain.entities.Client;
import com.seek.microservices.ms_clients.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    @Override
    public List<Client> findAll() {
        return List.of((Client) repository.findAll());
    }

    @Override
    public Client create(ClientRequest request) {

        Client client = Client.builder()
                        .name(request.getName())
                        .lastname(request.getLastname())
                        .age(request.getAge())
                        .birthday(request.getBirthday())
                        .build();

        return repository.save(client);
    }
}
