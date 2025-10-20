package io.github.rumplesteelskin.springboottutorials.main.events.payload;

import org.springframework.context.ApplicationListener;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.stereotype.Component;

@Component
public class PayloadListener implements ApplicationListener<PayloadApplicationEvent<String>> {
    @Override
    public void onApplicationEvent(PayloadApplicationEvent<String> event) {
        System.out.println("Payload event Triggered " + event.getPayload());
    }
}
