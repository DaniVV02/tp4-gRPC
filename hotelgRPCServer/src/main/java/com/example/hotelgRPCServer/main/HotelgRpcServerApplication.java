package com.example.hotelgRPCServer.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {
		"com.example.hotelgRPCServer.models"
})

@EnableJpaRepositories(basePackages = {
		"com.example.hotelgRPCServer.repositories"
})

@SpringBootApplication(scanBasePackages = {
		"com.example.hotelgRPCServer.data",
		"com.example.hotelgRPCServer.listener",
		"com.example.hotelgRPCServer.service"

})
public class HotelgRpcServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelgRpcServerApplication.class, args);
	}

}
