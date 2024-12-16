package com.example.hotelgRPCServer.repositories;

import com.example.hotelgRPCServer.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByClientId(Long clientId);

}
