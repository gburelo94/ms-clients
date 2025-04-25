package com.seek.microservices.ms_clients.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class ClientRequest {

    private String name;

    private String lastname;

    private int age;

    private LocalDate birthday;

}
