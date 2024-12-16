package com.example.hotelgRPCClient.cli;

import com.example.hotelgRPCClient.services.HotelServiceClient;
import com.example.hotelgRPCClient.services.ReservationServiceClient;
import com.google.protobuf.Empty;
import io.grpc.StatusRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import hotelProto.*;

import java.util.Scanner;

@Component
public class HotelClientCLI implements CommandLineRunner {

    @Autowired
    private HotelServiceClient hotelServiceClient;
    @Autowired
    private ReservationServiceClient reservationServiceClient;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String choice = "";

        System.out.println("\nBienvenu au menu principal : ");


        do {
            menu();
            choice = scanner.nextLine().trim();


            switch (choice) {
                case "1":
                    System.out.print("Entrez votre nom d'utilisateur: ");
                    String username = scanner.nextLine().trim();

                    System.out.print("Entrez votre mot de passe: ");
                    String password = scanner.nextLine().trim();

                    if (!validateCredentials(username, password)) {
                        break;
                    }

                    getHotels(username, password);
                    break;

                case "2":

                    System.out.print("Entrez votre nom d'utilisateur: ");
                    username = scanner.nextLine().trim();

                    System.out.print("Entrez votre mot de passe: ");
                    password = scanner.nextLine().trim();


                    if (!validateCredentials(username, password)) {
                        break;
                    }

                    System.out.println("Entrez la ville (laisser vide pour ignorer): ");
                    String city = scanner.nextLine().trim();

                    System.out.println("Entrez le nombre d'étoiles (0 pour ignorer): ");
                    int stars = Integer.parseInt(scanner.nextLine().trim());

                    System.out.println("Entrez le prix minimum (0 pour ignorer): ");
                    int minPrice = Integer.parseInt(scanner.nextLine().trim());

                    System.out.println("Entrez le prix maximum (0 pour ignorer): ");
                    int maxPrice = Integer.parseInt(scanner.nextLine().trim());

                    System.out.println("Entrez la date de début (yyyy-MM-dd, laisser vide pour ignorer): ");
                    String startDate = scanner.nextLine().trim();

                    System.out.println("Entrez la date de fin (yyyy-MM-dd, laisser vide pour ignorer): ");
                    String endDate = scanner.nextLine().trim();

                    searchHotel(username,password,city, stars, minPrice, maxPrice, startDate, endDate);
                    break;


                case "3":
                    System.out.print("Entrez votre nom d'utilisateur: ");
                    username = scanner.nextLine().trim();

                    System.out.print("Entrez votre mot de passe: ");
                    password = scanner.nextLine().trim();

                    if (!validateCredentials(username, password)) {
                        break;
                    }

                    System.out.println("Entrez votre id");
                    long id = Long.parseLong(scanner.nextLine().trim());

                    getReservations(username, password, id);
                    break;


                case "4":
                    System.out.print("Entrez votre nom d'utilisateur: ");
                    username = scanner.nextLine().trim();

                    System.out.print("Entrez votre mot de passe: ");
                    password = scanner.nextLine().trim();

                    if (!validateCredentials(username, password)) {
                        break;
                    }

                    System.out.print("Entrez le nom de l'hôtel: ");
                    String hotelName = scanner.nextLine().trim();

                    System.out.print("Entrez la date de réservation (yyyy-MM-dd): ");
                    String reservationDate = scanner.nextLine().trim();

                    System.out.print("Entrez votre prénom: ");
                    String guestFirstname = scanner.nextLine().trim();

                    System.out.print("Entrez votre nom: ");
                    String guestLastname = scanner.nextLine().trim();

                    System.out.print("Entrez votre numéro de carte bancaire: ");
                    String guestCB = scanner.nextLine().trim();

                    makeReservation(username, password, hotelName, reservationDate, guestFirstname, guestLastname, guestCB);
                    break;


                case "q":
                    System.out.println("Exiting CLI...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while(!choice.equals("q"));
    }

    private void menu() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("\nQue souhaitez vous faire :")
                .append("\n1. Visualiser les hotels")
                .append("\n2. Chercher selon des filtres")
                .append("\n3. Visualiser toutes mes réservations")
                .append("\n4. Faire une réservation")
                .append("\nq. Quit")
                .append("\nEcrivez votre choix : ");

        System.out.println(buffer);
    }

    private void getHotels(String username, String password) {
        try {
            GetAllHotelsRequest request = GetAllHotelsRequest.newBuilder()
                    .setUsr(username)
                    .setPass(password)
                    .build();

            SearchResponse hotelsList = hotelServiceClient.getHotels(request);

            System.out.println("Voici les hotels:");
            hotelsList.getHotelsList().forEach(hotel ->
                    System.out.printf("Hotel: %s, Etoiles: %d, Type de chambre: %s, Nombre de lits: %d, Date de disponibilite: %s," +
                                    "Prix : %f, Ville : %s, Image de la chambre : %s\n",
                            hotel.getName(), hotel.getEtoiles(),
                            hotel.getTypeChambre(), hotel.getNbLits(),
                            hotel.getDateDispo(), hotel.getPrix(), hotel.getVille(), hotel.getImageUrl()));
        } catch (StatusRuntimeException e) {
            System.err.println("Error: " + e.getStatus().getDescription());
        }
    }

    private void searchHotel(String user, String pass, String city, int stars, int minPrice, int maxPrice, String startDate, String endDate) {
        try {

            SearchRequest.Builder requestBuilder = SearchRequest.newBuilder()
                    .setUser(user)
                    .setPassw(pass);

            if (!city.isEmpty()) {
                requestBuilder.setCity(city);
            }
            if (stars > 0) {
                requestBuilder.setStars(stars);
            }
            if (minPrice > 0) {
                requestBuilder.setMinPrice(minPrice);
            }
            if (maxPrice > 0) {
                requestBuilder.setMaxPrice(maxPrice);
            }
            if (!startDate.isEmpty()) {
                requestBuilder.setStartDate(startDate);
            }
            if (!endDate.isEmpty()) {
                requestBuilder.setEndDate(endDate);
            }

            SearchRequest request = requestBuilder.build();

            SearchResponse response = hotelServiceClient.searchHotel(request);

            System.out.println("Hôtels trouvés:");
            response.getHotelsList().forEach(hotel ->
                    System.out.printf("Hotel : %s , Etoiles: %d, Type de chambre: %s, Nombre de lits: %d, Date de disponibilite : %s," +
                                    "Prix : %f, Ville : %s, Image de la chambre : %s\n",
                            hotel.getName(), hotel.getEtoiles(),
                            hotel.getTypeChambre(), hotel.getNbLits(),
                            hotel.getDateDispo(), hotel.getPrix(), hotel.getVille(), hotel.getImageUrl()));
        } catch (StatusRuntimeException e) {
            System.err.println("Error: " + e.getStatus().getDescription());
        }
    }

    private void getReservations(String username, String password, long id) {
        try {
            GetAllReservationsRequest request = GetAllReservationsRequest.newBuilder()
                    .setUsername(username)
                    .setPassword(password)
                    .setClientId(id)
                    .build();

            SearchReservation response = reservationServiceClient.getReservations(request);

            if (!response.getErrorMessage().isEmpty()) {
                System.out.println("Erreur : " + response.getErrorMessage());
                return;
            }

            if (response.getReservationsList().isEmpty()) {
                System.out.println("Aucune réservation trouvée pour cet utilisateur.");
                return;
            }

            System.out.println("Vos réservations:");
            response.getReservationsList().forEach(reservation ->
                    System.out.printf("Réservation ID: %s, Hôtel: %s, Date: %s, Client: %s%n",
                            reservation.getIdOffre(), reservation.getHotelName(),
                            reservation.getDateReservation(), reservation.getNomClient()));
        } catch (StatusRuntimeException e) {
            System.err.println("Error: " + e.getStatus().getDescription());
        }
    }

    private void makeReservation(String username, String password, String hotelName, String reservationDate,
                                 String guestFirstname, String guestLastname, String guestCB) {
        try {
            ReservationRequest request = ReservationRequest.newBuilder()
                    .setUsername(username)
                    .setPassword(password)
                    .setHotelName(hotelName)
                    .setDateReservation(reservationDate)
                    .setGuestFirstname(guestFirstname)
                    .setGuestLastname(guestLastname)
                    .setGuestCB(guestCB)
                    .build();

            ReservationResponse response = reservationServiceClient.makeReservation(request);

            if (!response.getSuccess()) {
                System.out.println("Erreur: " + response.getMessage());
            } else {
                System.out.println("Réservation confirmée! Référence de réservation: " + response.getBookingReference());
            }
        } catch (StatusRuntimeException e) {
            System.err.println("Error: " + e.getStatus().getDescription());
        }
    }

    private boolean validateCredentials(String username, String password) {
        try {
            ValidateUserRequest request = ValidateUserRequest.newBuilder()
                    .setUsername(username)
                    .setPassword(password)
                    .build();

            ValidateUserResponse response = hotelServiceClient.validateUser(request);

            if (!response.getValid()) {
                System.out.println("Erreur : " + response.getErrMessage());
                return false;
            }

            return true;
        } catch (StatusRuntimeException e) {
            System.err.println("Erreur lors de la validation des identifiants : " + e.getStatus().getDescription());
            return false;
        }
    }



}
