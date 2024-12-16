package org.example;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.grpc.User;
import org.example.grpc.userGrpc;

public class GRPCClient {
    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext().build();

        // stubs - genérés par protofiles

        userGrpc.userBlockingStub userStub = userGrpc.newBlockingStub(channel);


        User.LoginRequest loginRequest = User.LoginRequest.newBuilder().setUsername("admin").setPassword("admin").build();
        userStub.login(loginRequest);

        User.APIResponse response = userStub.login(loginRequest);

        System.out.println(response.getResponseMessage());

    }
}
