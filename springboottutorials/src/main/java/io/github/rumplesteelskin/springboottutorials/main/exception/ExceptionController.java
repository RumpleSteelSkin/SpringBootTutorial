package io.github.rumplesteelskin.springboottutorials.main.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exception")
@RequiredArgsConstructor
public class ExceptionController {
    private final ExceptionPerformer exceptionPerformer;

    @GetMapping("doException")
    public String doException() {
        exceptionPerformer.doRisky("Hello Risky");
        return "Risky method called";
    }

}
