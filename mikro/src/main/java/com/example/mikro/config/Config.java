package com.example.mikro.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Config {

    @EventListener
    public void onApplicationReady(ApplicationReadyEvent event) {
        String port = event.getApplicationContext()
                           .getEnvironment()
                           .getProperty("server.port", "9090");

        String contextPath = event.getApplicationContext()
                                  .getEnvironment()
                                  .getProperty("server.servlet.context-path", "/");

        System.out.println("✅ Mikro está corriendo en: http://localhost:" + port + contextPath);
    }
}
