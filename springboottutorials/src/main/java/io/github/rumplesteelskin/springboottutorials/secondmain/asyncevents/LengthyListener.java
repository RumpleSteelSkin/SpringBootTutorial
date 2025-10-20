package io.github.rumplesteelskin.springboottutorials.secondmain.asyncevents;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class LengthyListener {

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("Sleep interrupted: " + e.getMessage());
        }
    }

    @Async
    @EventListener
    public void asynchronousCalled(LengthyEvent event) {
        sleep();
        System.out.println("asynchronousCalled " + event.getMyField());
    }
}
