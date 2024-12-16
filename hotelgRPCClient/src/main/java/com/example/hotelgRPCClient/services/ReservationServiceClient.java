package com.example.hotelgRPCClient.services;

import hotelProto.*;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceClient {

    @GrpcClient("hotel-service")
    private ReservationServiceGrpc.ReservationServiceBlockingStub reservationServiceBlockingStub;

    public ValidateUserResponse validateUser(ValidateUserRequest validateUserRequest) {return reservationServiceBlockingStub.validateUser(validateUserRequest);}
    public SearchReservation getReservations(GetAllReservationsRequest reservationsRequest){return reservationServiceBlockingStub.getAllReservations(reservationsRequest);}
    public ReservationResponse makeReservation(ReservationRequest reservationRequest){return reservationServiceBlockingStub.makeReservation(reservationRequest);}

}
