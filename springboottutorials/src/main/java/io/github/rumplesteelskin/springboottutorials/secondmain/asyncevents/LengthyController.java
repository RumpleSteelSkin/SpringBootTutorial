package io.github.rumplesteelskin.springboottutorials.secondmain.asyncevents;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("SameReturnValue")
@RestController
@RequestMapping("lengthy")
@RequiredArgsConstructor
public class LengthyController {
    private final ApplicationEventPublisher applicationEventPublisher;

    @GetMapping("publish")
    public String publishAsync()
    {
        applicationEventPublisher.publishEvent(new LengthyEvent(this,"Long"));
        System.out.println("Long published");
        return "Long published";
    }
}
