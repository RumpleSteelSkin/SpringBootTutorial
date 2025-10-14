package io.github.rumplesteelskin.springboottutorials.SecondMain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTutorialsApplication2 {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringBootTutorialsApplication2.class);
        app.setAdditionalProfiles("batch");
        app.run(args);
    }

}
