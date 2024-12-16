package com.example.hotelgRPCServer.models;

import jakarta.persistence.*;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idReservation;
    private long offreId;
    private String dateReservation;
    private String nomClient;
    private String hotelName;
    private long clientId;

    public Reservation() {}


    public Reservation( long offreId, String dateReservation, String nomClient, String hotelName, long clientId) {
        this.offreId = offreId;
        this.dateReservation = dateReservation;
        this.nomClient = nomClient;
        this.hotelName = hotelName;
        this.clientId = clientId;
    }

    public long getIdReservation() {
        return idReservation;
    }

    public long getOffreId() {
        return offreId;
    }
    public String getDateReservation() {
        return dateReservation;
    }

    public String getNomClient() {
        return nomClient;
    }
    public String getHotelName() { return hotelName; }
    public long getClientId() { return clientId; }

    public void setIdReservation(long idReservation) {
        this.idReservation = idReservation;
    }
    public void setOffreId(long offreId) {
        this.offreId = offreId;
    }
    public void setDateReservation(String dateReservation) {
        this.dateReservation = dateReservation;
    }
    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
    public void setClientId(long clientId) {
        this.clientId = clientId;
    }


    @Override
    public String toString() {
        return "Reservation{" +
                "idReservation=" + idReservation +
                ", offreId=" + offreId +
                ", dateReservation='" + dateReservation + '\'' +
                ", nomClient='" + nomClient + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", clientId=" + clientId + '\'' +
                '}';
    }
}

