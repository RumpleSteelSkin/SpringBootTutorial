package io.github.rumplesteelskin.springboottutorials.Main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTutorialsApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringBootTutorialsApplication.class);
        app.setAdditionalProfiles("api");
        app.run(args);
    }

}
