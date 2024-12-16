package com.example.hotelgRPCServer.data;

import com.example.hotelgRPCServer.models.Agence;
import com.example.hotelgRPCServer.repositories.AgenceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AgenceData {
    /* Attributs */

    private Logger logger = LoggerFactory.getLogger(AgenceData.class);

    @Bean
    public CommandLineRunner initAgencegRPCDatabase(AgenceRepository repository) {
        return args -> {
            logger.info("Agence Database initialization started: " + repository.save(
                    new Agence( "JimenezAgence", "jim123", "123")
            ));
            logger.info("Client Database initialization started: " + repository.save(
                    new Agence("AlvAgence", "alv06", "456" )
            ));
            logger.info("Client Database initialization started: " + repository.save(
                    new Agence("La Croix", "BapTiste", "789")
            ));
            logger.info("Client Database initialization started: " + repository.save(
                    new Agence("The Best Agency", "Richi", "101")
            ));
            logger.info("Agence Data initialized : " + repository.findAll());

        };
    }
}
