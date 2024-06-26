package com.example.policyadminbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.policyadminbackend.SomeBean; // Assuming SomeBean is in com.example.policyadminbackend package

@Configuration
public class AppConfig {

    @Bean
    public SomeBean someBean() {
        return new SomeBean();
    }
}
