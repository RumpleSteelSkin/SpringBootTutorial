package io.github.rumplesteelskin.springboottutorials.main.executor;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("SameReturnValue")
@RestController
@RequestMapping("concurrent")
@RequiredArgsConstructor
public class ConcurrentController {
    private final ConcurrentPerformer concurrentPerformer;

    @GetMapping("doConcurrent")
    public String doConcurrent() {
        concurrentPerformer.doExecutor();
        return "Called concurrent";
    }
}
