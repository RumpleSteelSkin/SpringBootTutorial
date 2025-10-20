package io.github.rumplesteelskin.springboottutorials.main.exception;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


@Component
public class ExceptionPerformer {

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("Sleep interrupted: " + e.getMessage());
        }
    }

    @Async
    public void doRisky(String message) {
        sleep();
        System.out.println("Risky process is started; " + message);
        throw new RuntimeException("Risky!");
    }

}
