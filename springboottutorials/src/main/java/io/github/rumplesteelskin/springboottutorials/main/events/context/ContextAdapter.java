package io.github.rumplesteelskin.springboottutorials.main.events.context;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.*;

import java.text.SimpleDateFormat;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@Configuration
public class ContextAdapter {

    private static final Logger logger = Logger.getGlobal();

    static {
        logger.addHandler(new ConsoleHandler());
        logger.setLevel(Level.FINEST);
    }

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    @EventListener(ContextStartedEvent.class)
    public void handleContextStarted(ContextStartedEvent event) {
        logEvent("ContextStartedEvent received", event);
    }

    @EventListener(ContextStoppedEvent.class)
    public void handleContextStop(ContextStoppedEvent event) {
        logEvent("ContextStoppedEvent received", event);
    }

    @EventListener(ContextRefreshedEvent.class)
    public void handleContextRefreshed(ContextRefreshedEvent event) {
        logEvent("ContextRefreshedEvent received", event);
    }

    @EventListener(ContextClosedEvent.class)
    public void handleContextClosed(ContextClosedEvent event) {
        logEvent("ContextClosedEvent received", event);
    }

    private void logEvent(String message, ApplicationContextEvent event) {
        logger.log(Level.INFO, message + " @ " + sdf.format(event.getTimestamp()));
    }
}
