package com.seek.microservices.ms_clients.config;

import com.seek.microservices.ms_clients.domain.entities.User;
import com.seek.microservices.ms_clients.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class UserSeeder {
    private final PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner insertAdminUser(UserRepository repository) {
            return args -> {
                if (repository.findByUsername("admin").isEmpty()) {
                    User admin = User.builder()
                            .username("admin")
                            .password(passwordEncoder.encode("admin123"))
                            .role("ADMIN")
                            .build();

                    repository.save(admin);
                    System.out.println("✅ Usuario 'admin' insertado con éxito.");
                } else {
                    System.out.println("ℹ️ Usuario 'admin' ya existe. No se inserta.");
                }
            };
        }
}
