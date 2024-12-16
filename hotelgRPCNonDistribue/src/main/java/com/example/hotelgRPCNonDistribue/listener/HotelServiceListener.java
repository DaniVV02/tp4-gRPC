package com.example.hotelgRPCNonDistribue.listener;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class HotelServiceListener implements ApplicationListener<WebServerInitializedEvent> {

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        int port = event.getWebServer().getPort();
        String contextPath = event.getApplicationContext().getApplicationName();
        System.out.println("============================================");
        System.out.println("Application démarrée et disponible à l'adresse : ");
        System.out.println("http://localhost:" + port + contextPath);
        System.out.println("============================================");
    }
}
