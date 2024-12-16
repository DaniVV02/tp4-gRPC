package org.example.user;

import io.grpc.stub.StreamObserver;
import org.example.grpc.User;
import org.example.grpc.userGrpc;

public class UserService extends userGrpc.userImplBase {
    @Override
    public void login(User.LoginRequest request, StreamObserver<User.APIResponse> responseObserver) {
        System.out.println("Inside login method");

        String username = request.getUsername();
        String password = request.getPassword();


        User.APIResponse.Builder response = User.APIResponse.newBuilder();
        if(username.equals(password)) {
            response.setResponseCode(0).setResponseMessage("Success");
        }else {
            response.setResponseCode(100).setResponseMessage("Invalid username or password");

        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(User.Empty request, StreamObserver<User.APIResponse> responseObserver) {
        User.APIResponse.Builder response = User.APIResponse.newBuilder();

        response.setResponseCode(0).setResponseMessage("Logout Successful");
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
