package com.seek.microservices.ms_clients.domain.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequest {

    @NotBlank(message = "El nombre es obligatorio.")
    private String name;

    @NotBlank(message = "El apellido es obligatorio.")
    private String lastname;

    @NotNull(message = "La edad es obligatoria.")
    @Min(value = 0, message = "La edad no puede ser negativa.")
    private int age;

    @NotNull(message = "La fecha de nacimiento es obligatoria.")
    private LocalDate birthday;

}
