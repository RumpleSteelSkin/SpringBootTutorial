package io.github.rumplesteelskin.springboottutorials.main.executor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ConcurrentPerformer {
    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("Sleep interrupted: " + e.getMessage());
        }
    }

    @Async("threadPoolTaskExecutor")
    public void doExecutor() {
        sleep();
        System.out.println("Concurrent Async doExecutor");
    }

}
