package io.github.rumplesteelskin.springboottutorials.main.events.annotation;

import io.github.rumplesteelskin.springboottutorials.main.events.application.OperationEvent;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AnnotationListener {
    @EventListener
    public void onOperationPerformed(OperationEvent event) {
        System.out.println("Annotation Application Event Triggered " + event.getMyField());
    }

    @EventListener
    public void onPayloadReceived(PayloadApplicationEvent<String> event) {
        System.out.println("Annotation Payload event Triggered " + event.getPayload());
    }
}
