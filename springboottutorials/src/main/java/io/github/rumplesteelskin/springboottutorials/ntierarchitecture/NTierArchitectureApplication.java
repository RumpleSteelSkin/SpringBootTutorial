package io.github.rumplesteelskin.springboottutorials.ntierarchitecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NTierArchitectureApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(io.github.rumplesteelskin.springboottutorials.ntierarchitecture.NTierArchitectureApplication.class);
        app.setAdditionalProfiles("ntier");
        app.run(args);
    }
}