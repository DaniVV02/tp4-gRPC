package com.example.hotelgRPCClient.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.example.hotelgRPCClient.cli",
		"com.example.hotelgRPCClient.services"
})
public class HotelgRpcClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelgRpcClientApplication.class, args);
	}

}
