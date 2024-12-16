package com.example.hotelgRPCServer.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idClient;
    private String firstName;
    private String lastName;
    private String creditCardLastNumbers;

    public Client() {}

    public Client(String firstName, String lastName, String creditCardLastNumbers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.creditCardLastNumbers = creditCardLastNumbers;
    }
    public long getIdClient() {
        return idClient;
    }
    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getCreditCardLastNumbers() {
        return creditCardLastNumbers;
    }
    public void setCreditCardLastNumbers(String creditCardLastNumbers) {
        this.creditCardLastNumbers = creditCardLastNumbers;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", creditCardLastNumbers='" + creditCardLastNumbers + '\'' +
                '}';
    }
}
