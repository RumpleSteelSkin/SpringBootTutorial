package io.github.rumplesteelskin.springboottutorials.main.async;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@SuppressWarnings("SameReturnValue")
@RestController
@RequestMapping("method")
@RequiredArgsConstructor
public class MethodController {

    private final MethodPerformer methodPerformer;

    @GetMapping("asyncDo")
    public String asyncDo() {
        methodPerformer.doSomething();
        return "asyncDo";
    }


    @SuppressWarnings("BusyWait")
    @GetMapping("asyncAndSyncDo")
    public String asyncAndSyncDo() {
        try {
            //return methodPerformer.getSomething().get();
            Future<String> future = methodPerformer.getSomething();
            while (true) {
                if (future.isDone()) {
                    return "asyncAndSyncDo " + future.get();
                }
                System.out.println("Response is waiting...");
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            return "asyncAndSyncDo interrupted: " + e.getMessage();
        }
    }

}
