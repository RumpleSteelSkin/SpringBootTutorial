package io.github.rumplesteelskin.springboottutorials.main.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Component
public class MethodPerformer {
    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("Sleep interrupted: " + e.getMessage());
        }
    }

    @Async
    public void doSomething() {
        sleep();
        System.out.println("Async doSomething");
    }

    @Async
    public Future<String> getSomething() {
        sleep();
        System.out.println("Async doSomething");
        return CompletableFuture.completedFuture("Sync doSomething");
    }
}
