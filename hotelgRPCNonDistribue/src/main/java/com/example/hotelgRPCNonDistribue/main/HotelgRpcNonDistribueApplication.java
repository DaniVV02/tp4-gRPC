package com.example.hotelgRPCNonDistribue.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = {
		"com.example.hotelgRPCNonDistribue.listener",
		"com.example.hotelgRPCNonDistribue.server",
		"com.example.hotelgRPCNonDistribue.services"

})
public class HotelgRpcNonDistribueApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelgRpcNonDistribueApplication.class, args);
	}

}
