package com.example.hotelgRPCServer.service;

import com.example.hotelgRPCServer.models.Agence;
import com.example.hotelgRPCServer.models.Reservation;
import com.example.hotelgRPCServer.repositories.AgenceRepository;
import com.example.hotelgRPCServer.repositories.HotelRepository;
import com.example.hotelgRPCServer.repositories.ReservationRepository;
import hotelProto.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.time.LocalDate;
import java.util.Optional;


@GrpcService
public class HotelServiceImpl extends HotelServiceGrpc.HotelServiceImplBase {

    private final HotelRepository hotelRepository;
    private final AgenceRepository agenceRepository;

    public HotelServiceImpl(HotelRepository hotelRepository, AgenceRepository agenceRepository) {
        this.hotelRepository = hotelRepository;
        this.agenceRepository = agenceRepository;
    }

    private Optional<Agence> validateUserCredentials(String username, String password) {
        return agenceRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public void validateUser(ValidateUserRequest request, StreamObserver<ValidateUserResponse> responseObserver) {
        String username = request.getUsername();
        String password = request.getPassword();

        Optional<Agence> valid = validateUserCredentials(username, password); // Méthode pour vérifier les identifiants
        if (valid.isEmpty()) {
            responseObserver.onNext(ValidateUserResponse.newBuilder()
                    .setErrMessage("Invalid username or password. Please try again.")
                    .build()); // Réponse vide
            responseObserver.onCompleted();
            return;
        }

        ValidateUserResponse response = ValidateUserResponse.newBuilder()
                .setValid(true)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void getAllHotels(GetAllHotelsRequest request, StreamObserver<SearchResponse> responseObserver) {
        SearchResponse.Builder response = SearchResponse.newBuilder();

        Optional<Agence> agenceOptional = validateUserCredentials(request.getUsr(), request.getPass());

        if (agenceOptional.isEmpty()) {
            responseObserver.onNext(SearchResponse.newBuilder()
                    .setErrorMessage("Invalid username or password. Please try again.")
                    .build()); // Réponse vide
            responseObserver.onCompleted();
            return;
        }

        hotelRepository.findAll().forEach(hotel -> response.addHotels(
                Hotel.newBuilder()
                        .setName(hotel.getName())
                        .setEtoiles(hotel.getEtoiles())
                        .setTypeChambre(hotel.getTypeChambre())
                        .setNbLits(hotel.getNombreLits())
                        .setDateDispo(hotel.getDateDisponibilite())
                        .setPrix(hotel.getPrix())
                        .setVille(hotel.getVille())
                        .setImageUrl(hotel.getImageUrl())
                        .build()
        ));

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }


    @Override
    public void searchHotels(SearchRequest request, StreamObserver<SearchResponse> responseObserver) {
        SearchResponse.Builder response = SearchResponse.newBuilder();

        Optional<Agence> agenceOptional = validateUserCredentials(request.getUser(), request.getPassw());

        if (agenceOptional.isEmpty()) {
            responseObserver.onNext(SearchResponse.newBuilder()
                    .setErrorMessage("Invalid username or password. Please try again.")
                    .build()); // Réponse vide
            responseObserver.onCompleted();
            return;
        }


        LocalDate startDate = request.getStartDate().isEmpty() ? null : LocalDate.parse(request.getStartDate());
        LocalDate endDate = request.getEndDate().isEmpty() ? null : LocalDate.parse(request.getEndDate());

        System.out.println("Requête reçue : " + request);


        hotelRepository.findAll().stream()
                .filter(hotel -> request.getCity().isEmpty() || hotel.getVille().equalsIgnoreCase(request.getCity()))
                .filter(hotel -> request.getStars() == 0 || hotel.getEtoiles() == request.getStars())
                .filter(hotel -> request.getMinPrice() == 0 || hotel.getPrix() >= request.getMinPrice())
                .filter(hotel -> request.getMaxPrice() == 0 || hotel.getPrix() <= request.getMaxPrice())
                .filter(hotel -> {
                    if (startDate != null) {
                        LocalDate hotelDate = LocalDate.parse(hotel.getDateDisponibilite());
                        return !hotelDate.isAfter(startDate);
                    }
                    return true; // Pas de critere de date
                })
                .forEach(hotel -> response.addHotels(
                        Hotel.newBuilder()
                                .setName(hotel.getName())
                                .setEtoiles(hotel.getEtoiles())
                                .setTypeChambre(hotel.getTypeChambre())
                                .setNbLits(hotel.getNombreLits())
                                .setDateDispo(hotel.getDateDisponibilite())
                                .setPrix(hotel.getPrix())
                                .setVille(hotel.getVille())
                                .setImageUrl(hotel.getImageUrl())
                                .build()
                ));

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }


}
