package com.example.hotelgRPCServer.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAgence;
    private String nomAgence;
    private String username;
    private String password;

    public Agence() {}

    public Agence(String nomAgence, String username, String password) {
        this.nomAgence = nomAgence;
        this.username = username;
        this.password = password;
    }

    public long getIdAgence() {
        return idAgence;
    }

    public String getNomAgence() {
        return nomAgence;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Agence{" +
                "idAgence=" + idAgence +
                ", nomAgence='" + nomAgence + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
