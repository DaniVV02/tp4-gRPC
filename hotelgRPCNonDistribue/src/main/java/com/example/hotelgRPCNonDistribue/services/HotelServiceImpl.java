package com.example.hotelgRPCNonDistribue.services;

import com.example.hotelgRPCNonDistribue.models.Hotel;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;
import proto.HotelOuterClass;
import proto.HotelServiceGrpc;

import java.util.ArrayList;
import java.util.List;


public class HotelServiceImpl extends HotelServiceGrpc.HotelServiceImplBase {
    private final List<Hotel> hotels = new ArrayList<>();

    public HotelServiceImpl() {
        hotels.add(new Hotel("Michi", 4,"Double", 3, "2024-12-18", 50));
        hotels.add(new Hotel("La Tour", 5, "SUite", 4, "2024-12-24", 30));
    }


    @Override
    public void searchHotels(HotelOuterClass.SearchRequest request, StreamObserver<HotelOuterClass.SearchResponse> responseObserver) {
        HotelOuterClass.SearchResponse.Builder response = HotelOuterClass.SearchResponse.newBuilder();

        for (Hotel hotel : hotels) {
            if (hotel.matches(request)) {
                response.addHotels(hotel.toProto());
            }
        }


        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void makeReservation(HotelOuterClass.ReservationRequest request, StreamObserver<HotelOuterClass.ReservationResponse> responseObserver) {
        HotelOuterClass.ReservationResponse response;
        // Simulate reservation logic
        response = HotelOuterClass.ReservationResponse.newBuilder()
                .setSuccess(true)
                .setMessage("Reservation confirmed!")
                .setBookingReference("RES123456")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

