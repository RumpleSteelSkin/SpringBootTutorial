package io.github.rumplesteelskin.springboottutorials.main.events.application;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class OperationListener implements ApplicationListener<OperationEvent> {
    @Override
    public void onApplicationEvent(OperationEvent event) {
        System.out.println("Application Event Triggered " + event.getMyField());
    }
}
