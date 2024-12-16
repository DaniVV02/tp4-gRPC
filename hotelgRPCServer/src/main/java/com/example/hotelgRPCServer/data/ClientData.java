package com.example.hotelgRPCServer.data;

import com.example.hotelgRPCServer.models.Agence;
import com.example.hotelgRPCServer.models.Client;
import com.example.hotelgRPCServer.repositories.AgenceRepository;
import com.example.hotelgRPCServer.repositories.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientData {
    /* Attributs */

    private Logger logger = LoggerFactory.getLogger(ClientData.class);

    @Bean
    public CommandLineRunner initClientDatabase(ClientRepository repository) {
        return args -> {
            logger.info("Client Database initialization started: " + repository.save(
                    new Client( "Daniel", "Vargas", "1234")
            ));
            logger.info("Client Database initialization started: " + repository.save(
                    new Client("Baptiste", "De la Croix", "6789" )
            ));
            logger.info("Client Database initialization started: " + repository.save(
                    new Client("Max", "Houston", "5467")
            ));
            logger.info("Client Database initialization started: " + repository.save(
                    new Client("Richard", "Brown", "9345")
            ));
            logger.info("Client Data initialized : " + repository.findAll());

        };
    }
}