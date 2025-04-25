package com.seek.microservices.ms_clients.domain.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientMetricsResponse {

    private double averageAge;

    private double standardDeviation;
}
