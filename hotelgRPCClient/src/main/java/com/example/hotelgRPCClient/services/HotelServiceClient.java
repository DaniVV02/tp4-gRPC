package com.example.hotelgRPCClient.services;

import hotelProto.*;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceClient {

    @GrpcClient("hotel-service")
    private HotelServiceGrpc.HotelServiceBlockingStub hotelServiceBlockingStub;

    public ValidateUserResponse validateUser(ValidateUserRequest validateUserRequest) {return hotelServiceBlockingStub.validateUser(validateUserRequest);}
    public SearchResponse getHotels(GetAllHotelsRequest searchRequest) { return hotelServiceBlockingStub.getAllHotels(searchRequest);}
    public SearchResponse searchHotel(SearchRequest searchRequest) { return hotelServiceBlockingStub.searchHotels(searchRequest); }

}
