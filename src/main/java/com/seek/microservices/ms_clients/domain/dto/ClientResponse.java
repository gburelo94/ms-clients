package com.seek.microservices.ms_clients.domain.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponse {

    private Long id;

    private String name;

    private String lastname;

    private int age;

    private LocalDate birthday;

    private LocalDate dateDeath;
}
