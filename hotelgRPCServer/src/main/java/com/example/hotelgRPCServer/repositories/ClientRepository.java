package com.example.hotelgRPCServer.repositories;

import com.example.hotelgRPCServer.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
