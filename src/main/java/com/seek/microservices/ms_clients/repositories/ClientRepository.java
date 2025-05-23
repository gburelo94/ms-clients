package com.seek.microservices.ms_clients.repositories;

import com.seek.microservices.ms_clients.domain.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
