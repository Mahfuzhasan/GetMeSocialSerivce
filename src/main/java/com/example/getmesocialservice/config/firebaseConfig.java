package com.example.getmesocialservice.config;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class firebaseConfig {

    @Bean
    public FirebaseApp initializefirebase(  ) throws IOException {

        PathMatchingResourcePatternResolver resolver= new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("classpath:firebase.json");
        FileInputStream serviceAccount =
                new FileInputStream(resource.getFile());

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        return   FirebaseApp.initializeApp(options);

    }
}
