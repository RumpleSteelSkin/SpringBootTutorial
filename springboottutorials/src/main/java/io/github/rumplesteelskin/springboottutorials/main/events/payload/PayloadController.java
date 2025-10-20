package io.github.rumplesteelskin.springboottutorials.main.events.payload;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payload")
@RequiredArgsConstructor
public class PayloadController {

    private final ApplicationEventPublisher applicationEventPublisher;

    @GetMapping("publish")
    public String publishPayload() {
        applicationEventPublisher.publishEvent("My String");
        return "Publishing Payload Event";
    }
}
