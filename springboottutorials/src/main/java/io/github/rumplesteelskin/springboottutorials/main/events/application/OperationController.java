package io.github.rumplesteelskin.springboottutorials.main.events.application;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("operation")
@RequiredArgsConstructor
public class OperationController {

    private final ApplicationEventPublisher applicationEventPublisher;

    @GetMapping("publish")
    public void publishOperation() {
        applicationEventPublisher.publishEvent(new OperationEvent(this, "Values"));
        System.out.println("Publishing Operation Event");
    }
}
