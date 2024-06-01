package com.crud_api.demo;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Configuration
public class FirebaseConfig {

    @Bean
    public FirebaseApp initializeFirebase() throws IOException {
        // Load the service account key JSON file from the classpath
        Resource resource = new ClassPathResource("serviceAccountKey.json");

        // Initialize FirebaseOptions using the service account key JSON
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(resource.getInputStream()))
                .build();

        // Initialize the default FirebaseApp instance
        FirebaseApp.initializeApp(options);

        return FirebaseApp.getInstance();
    }
}
