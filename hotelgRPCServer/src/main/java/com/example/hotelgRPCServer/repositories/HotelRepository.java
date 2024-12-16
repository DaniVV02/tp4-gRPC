package com.example.hotelgRPCServer.repositories;

import com.example.hotelgRPCServer.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface HotelRepository extends JpaRepository<Hotel, Long> {
    Optional<Hotel> findById(Long id);
    long count();

    Optional<Hotel> findByName(String hotelName);
}
