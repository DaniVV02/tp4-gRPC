package com.example.hotelgRPCNonDistribue.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import proto.HotelOuterClass;


public class Hotel {
    private String name;
    private int etoiles;
    private String typeChambre;
    private int nombreLits;
    private String dateDisponibilite;
    private double prix;


    public Hotel() {}

    public Hotel(String name, int etoiles, String typeChambre, int nombreLits, String dateDisponibilite, double prix) {
        this.name = name;
        this.etoiles = etoiles;
        this.typeChambre = typeChambre;
        this.nombreLits = nombreLits;
        this.dateDisponibilite = dateDisponibilite;
        this.prix = prix;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getEtoiles() {
        return etoiles;
    }
    public void setEtoiles(int etoiles) {
        this.etoiles = etoiles;
    }

    public String getTypeChambre() {
        return typeChambre;
    }
    public int getNombreLits() {
        return nombreLits;
    }
    public String getDateDisponibilite() {
        return dateDisponibilite;
    }
    public double getPrix() {
        return prix;
    }


    public void setTypeChambre(String typeChambre) {
        this.typeChambre = typeChambre;
    }
    public void setNombreLits(int nombreLits) {
        this.nombreLits = nombreLits;
    }
    public void setDateDisponibilite(String dateDisponibilite) {
        this.dateDisponibilite = dateDisponibilite;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }


    @Override
    public String toString() {
        return "Hotel{" +
                ", name='" + name + '\'' +
                ", typeChambre='" + typeChambre + '\'' +
                ", nombreLits=" + nombreLits +
                ", dateDisponibilite='" + dateDisponibilite + '\'' +
                ", prix=" + prix +
                '}';
    }

    // Méthode pour vérifier si un hôtel correspond aux critères de recherche
    public boolean matches(HotelOuterClass.SearchRequest request) {
        return request.getStars() <= etoiles // Vérifie les étoiles
                && request.getMinPrice() <= prix // Vérifie le prix minimum
                && request.getMaxPrice() >= prix // Vérifie le prix maximum
                && nombreLits >= request.getNumPeople(); // Vérifie le nombre de lits
    }

    public HotelOuterClass.Hotel toProto() {
        return HotelOuterClass.Hotel.newBuilder()
                .setName(name)
                .setEtoiles(etoiles)
                .setTypeChambre(typeChambre)
                .setNbLits(nombreLits)
                .setDateDispo(dateDisponibilite)
                .setPrix(prix)
                .build();
    }

}
