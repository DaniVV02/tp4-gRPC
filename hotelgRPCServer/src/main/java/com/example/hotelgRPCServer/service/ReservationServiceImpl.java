package com.example.hotelgRPCServer.service;

import com.example.hotelgRPCServer.models.Agence;
import com.example.hotelgRPCServer.models.Client;
import com.example.hotelgRPCServer.models.Reservation;
import com.example.hotelgRPCServer.repositories.AgenceRepository;
import com.example.hotelgRPCServer.repositories.ClientRepository;
import com.example.hotelgRPCServer.repositories.HotelRepository;
import com.example.hotelgRPCServer.repositories.ReservationRepository;
import hotelProto.ReservationRequest;
import hotelProto.ReservationResponse;
import hotelProto.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@GrpcService
public class ReservationServiceImpl extends ReservationServiceGrpc.ReservationServiceImplBase {

    private final HotelRepository hotelRepository;
    private final ReservationRepository reservationRepository;
    private final AgenceRepository agenceRepository;
    private final ClientRepository clientRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, HotelRepository hotelRepository, AgenceRepository agenceRepository, ClientRepository clientRepository) {
        this.hotelRepository = hotelRepository;
        this.reservationRepository = reservationRepository;
        this.agenceRepository = agenceRepository;
        this.clientRepository = clientRepository;
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
    public void getAllReservations(GetAllReservationsRequest request, StreamObserver<SearchReservation> responseObserver) {

        SearchReservation.Builder response = SearchReservation.newBuilder();

        Optional<Agence> agenceOptional = validateUserCredentials(request.getUsername(), request.getPassword());

        if (agenceOptional.isEmpty()) {
            responseObserver.onNext(SearchReservation.newBuilder()
                    .setErrorMessage("Invalid username or password. Please try again.")
                    .build()); // Réponse vide
            responseObserver.onCompleted();
            return;
        }

        long clientId = request.getClientId();
        System.out.println("Client ID: " + clientId);

        reservationRepository.findAllByClientId(clientId).forEach(reservation ->
                response.addReservations(
                        hotelProto.Reservation.newBuilder()
                                .setIdOffre(reservation.getOffreId())
                                .setDateReservation(reservation.getDateReservation())
                                .setNomClient(reservation.getNomClient())
                                .setHotelName(reservation.getHotelName())
                                .build()
                )
        );

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void makeReservation(ReservationRequest request, StreamObserver<ReservationResponse> responseObserver) {

        Optional<Agence> agenceOptional = validateUserCredentials(request.getUsername(), request.getPassword());

        if (agenceOptional.isEmpty()) {
            responseObserver.onNext(ReservationResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Invalid user credentials!")
                    .build());
            responseObserver.onCompleted();
            return;
        }

        var hotel = hotelRepository.findByName(request.getHotelName());

        if (hotel == null) {
            responseObserver.onNext(ReservationResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Hotel not found!")
                    .build());
            responseObserver.onCompleted();
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate availableDate = LocalDate.parse(hotel.get().getDateDisponibilite(), formatter);
        LocalDate reservationDate = LocalDate.parse(request.getDateReservation(), formatter);


        if (availableDate.isAfter(reservationDate)) {
            responseObserver.onNext(ReservationResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Hotel not available on the requested date!")
                    .build());
            responseObserver.onCompleted();
            return;
        }

        var client = new Client(request.getGuestFirstname(), request.getGuestLastname(), request.getGuestCB());
        clientRepository.save(client);

        var reservation = new Reservation();
        reservation.setOffreId(hotel.get().getId());
        reservation.setHotelName(request.getHotelName());
        reservation.setNomClient(request.getGuestFirstname());
        reservation.setDateReservation(request.getDateReservation());
        reservation.setClientId(client.getIdClient());
        reservationRepository.save(reservation);

        String bookingReference = "RES" + System.currentTimeMillis();

        responseObserver.onNext(ReservationResponse.newBuilder()
                .setSuccess(true)
                .setMessage("Reservation confirmed!")
                .setBookingReference(bookingReference)
                .build());
        responseObserver.onCompleted();
    }
}
