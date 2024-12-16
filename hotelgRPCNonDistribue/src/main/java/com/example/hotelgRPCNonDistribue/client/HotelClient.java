package com.example.hotelgRPCNonDistribue.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import proto.HotelOuterClass;
import proto.HotelServiceGrpc;

public class HotelClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8081)
                .usePlaintext()
                .build();

        HotelServiceGrpc.HotelServiceBlockingStub stub = HotelServiceGrpc.newBlockingStub(channel);

        HotelOuterClass.SearchRequest searchRequest = HotelOuterClass.SearchRequest.newBuilder()
                .setCity("Paris")
                .setStartDate("2024-12-15")
                .setEndDate("2024-12-30")
                .setMinPrice(20)
                .setMaxPrice(200)
                .setStars(3)
                .setNumPeople(2)
                .build();

        HotelOuterClass.SearchResponse response = stub.searchHotels(searchRequest);
        System.out.println("Available hotels: \n" + response.getHotelsList());

        // Simulate reservation...
        HotelOuterClass.ReservationRequest reservationRequest = HotelOuterClass.ReservationRequest.newBuilder()
                .setHotelName("Hotel Paris")
                .setGuestName("Mari Carmen")
                .setDateReservation("2024-12-15")
                .build();

        HotelOuterClass.ReservationResponse reservationResponse = stub.makeReservation(reservationRequest);
        System.out.println("Reservation: " + reservationResponse.getMessage() + " Booking reference : " + reservationResponse.getBookingReference());

        channel.shutdown();
    }
}
