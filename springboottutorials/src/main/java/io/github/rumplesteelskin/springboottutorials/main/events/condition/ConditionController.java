package io.github.rumplesteelskin.springboottutorials.main.events.condition;

import io.github.rumplesteelskin.springboottutorials.main.events.application.OperationEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("condition")
@RequiredArgsConstructor
public class ConditionController {

    private final ApplicationEventPublisher applicationEventPublisher;

    @GetMapping("true")
    public void conditionTrue() {
        applicationEventPublisher.publishEvent(new OperationEvent(this, "Zumba"));
    }

    @GetMapping("false")
    public void conditionFalse() {
        applicationEventPublisher.publishEvent(new OperationEvent(this, "Zımba"));
    }

}
