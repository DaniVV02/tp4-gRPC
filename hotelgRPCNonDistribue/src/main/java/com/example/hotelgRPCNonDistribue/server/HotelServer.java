package com.example.hotelgRPCNonDistribue.server;

import com.example.hotelgRPCNonDistribue.services.HotelServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class HotelServer implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Server server = ServerBuilder.forPort(8081)
                .addService(new HotelServiceImpl())
                .build();

        System.out.println("Server started at port 8081");
        server.start();
        server.awaitTermination();
    }
}
