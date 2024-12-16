package com.example.hotelgRPCServer.data;

import com.example.hotelgRPCServer.models.Reservation;
import com.example.hotelgRPCServer.repositories.ReservationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReservationData {
    private Logger logger = LoggerFactory.getLogger(ReservationData.class);

    @Bean
    public CommandLineRunner initReservationgRPCDatabase(ReservationRepository repository) {
        return args -> {
            logger.info("Initializing reservations: " + repository.save(
                    new Reservation(1, "2024-11-25", "Daniel", "Paris",1)
            ));
            logger.info("Initializing reservations: " + repository.save(
                    new Reservation(3, "2024-11-19", "Richard", "Loisir",4)
            ));
            logger.info("Reservations initialized: " + repository.findAll());
        };
    }
}
