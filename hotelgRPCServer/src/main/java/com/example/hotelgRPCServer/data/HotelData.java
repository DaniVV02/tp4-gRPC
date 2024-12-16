package com.example.hotelgRPCServer.data;

import com.example.hotelgRPCServer.models.Hotel;
import com.example.hotelgRPCServer.repositories.HotelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class HotelData {
    /* Attributs */

    private Logger logger = LoggerFactory.getLogger(HotelData.class);

    @Bean
    public CommandLineRunner initHotelgRPCDatabase(HotelRepository repository) {
        return args -> {
            logger.info("Hotel Database initialization started: " + repository.save(
                    new Hotel( "Paris", 4, "Double", 2, "2024-12-01", 100.0, "Paris", "http://localhost:8080/ParisDouble.jpg")
            ));
            logger.info("Hotel Database initialization started: " + repository.save(
                    new Hotel("Ibis",  4, "Suite", 4, "2024-12-10", 200.0, "Montpellier", "http://localhost:8080/IbisSuite.JPG")
            ));
            logger.info("Hotel Database initialization started: " + repository.save(
                    new Hotel("Loisir", 3, "Simple", 1, "2024-12-15", 80.0, "Toulouse", "http://localhost:8080/LoisirSimple.jpg")
            ));
            logger.info("Hotel Database initialization started: " + repository.save(
                    new Hotel( "Marriott", 5, "Suite", 2, "2024-12-20", 300.0, "Paris","http://localhost:8080/MarriottSuite.jpg")
            ));
            logger.info("Hotel Data initialized : " + repository.findAll());

        };
    }
}

