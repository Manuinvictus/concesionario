package com.salesianos.concesionario.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.salesianos.concesionario.repository.VendedoresRepository;
import com.salesianos.concesionario.model.Vendedor;

@Component
@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initializeDatabase(VendedoresRepository vr) {
        return args -> {
            if (vr.count() == 0) {
                Vendedor v = new Vendedor(0, "No vendido/ Vendedor desconocido", "", null, "", "");
                vr.save(v);
            }
        };
    }
}