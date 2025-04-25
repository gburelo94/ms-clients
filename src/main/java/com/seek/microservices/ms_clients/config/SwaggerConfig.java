package com.seek.microservices.ms_clients.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI info(){
        return new OpenAPI().info(new Info()
                .title("API Clients")
                .description("Microservicio demostrativo para la gestión de clientes y sus métricas.")
                .version("1.0.0"));
    }
}
