package com.example.hotelgRPCServer.models;

import hotelProto.HotelOuterClass;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int etoiles;
    private String typeChambre;
    private int nombreLits;
    private String dateDisponibilite;
    private double prix;
    private String ville;
    private String imageUrl;


    public Hotel() {}

    public Hotel(String name, int etoiles, String typeChambre, int nombreLits, String dateDisponibilite, double prix, String ville, String imageUrl) {
        this.name = name;
        this.etoiles = etoiles;
        this.typeChambre = typeChambre;
        this.nombreLits = nombreLits;
        this.dateDisponibilite = dateDisponibilite;
        this.prix = prix;
        this.ville = ville;
        this.imageUrl = imageUrl;

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
    public String getVille() {
        return ville;
    }
    public String getImageUrl() { return imageUrl; }


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
    public void setVille(String ville) {
        this.ville = ville;
    }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    @Override
    public String toString() {
        return "Hotel{" +
                "idOffre='" + id + '\'' +
                ", name='" + name + '\'' +
                ", typeChambre='" + typeChambre + '\'' +
                ", nombreLits=" + nombreLits +
                ", dateDisponibilite='" + dateDisponibilite + '\'' +
                ", prix=" + prix +
                ", ville='" + ville + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public boolean isAvailableOn(String requestedDate) {
        return dateDisponibilite.equals(requestedDate);
    }


}
