package com.example.hotelgRPCServer.repositories;

import com.example.hotelgRPCServer.models.Agence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgenceRepository extends JpaRepository<Agence, Long> {
    Optional<Agence> findByUsernameAndPassword(String username, String password);

}
