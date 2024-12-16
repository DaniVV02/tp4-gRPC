package com.example.hotelgRPCNonDistribue.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class Reservation {
    private long offreId;
    private String dateReservation;
    private String nomClient;

    public Reservation() {}


    public Reservation( long offreId, String dateReservation, String nomClient) {
        this.offreId = offreId;
        this.dateReservation = dateReservation;
        this.nomClient = nomClient;
    }


/*
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    */

    public long getOffreId() {
        return offreId;
    }
    public String getDateReservation() {
        return dateReservation;
    }


    public String getNomClient() {
        return nomClient;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                ", offreId='" + offreId + '\'' +
                ", dateReservation='" + dateReservation + '\'' +
                '}';
    }
}

