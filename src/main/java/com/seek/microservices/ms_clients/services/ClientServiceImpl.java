package com.seek.microservices.ms_clients.services;

import com.seek.microservices.ms_clients.domain.dto.ClientMetricsResponse;
import com.seek.microservices.ms_clients.domain.dto.ClientRequest;
import com.seek.microservices.ms_clients.domain.dto.ClientResponse;
import com.seek.microservices.ms_clients.domain.entities.Client;
import com.seek.microservices.ms_clients.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    @Override
    public List<ClientResponse> findAll() {
        return repository.findAll().stream().map(x -> {
            ClientResponse item = new ClientResponse();
            BeanUtils.copyProperties(x, item);
            item.setDateDeath(x.getBirthday().plusYears(80));
            return item;
        }).toList();

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

    @Override
    public ClientMetricsResponse getMetrics() {

        List<Integer> ages = repository.findAll()
                .stream()
                .map(Client::getAge)
                .toList();

        double average = ages
                .stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        double deviation = ages
                .stream()
                .mapToDouble(x -> Math.pow(x - average, 2))
                .average()
                .orElse(0.0);

        return ClientMetricsResponse.builder()
                .averageAge(average)
                .standardDeviation(deviation)
                .build();
    }
}
