package com.example.hotelgRPCNonDistribue.models;

public class Client {
    private String nom;
    private String prenom;
    private String email;
    private String telephone;

    public Client() {}

    public Client(String nom, String prenom, String email, String telephone) {

        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
    }


    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getEmail() {
        return email;
    }
    public String getTelephone() {
        return telephone;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Client{" +
                " nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
