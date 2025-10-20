package io.github.rumplesteelskin.springboottutorials.main.events.condition;

import io.github.rumplesteelskin.springboottutorials.main.events.application.OperationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ConditionListener {
    @EventListener(condition = "#event.myField.equals('Zumba')")
    public void onConditionTrue(OperationEvent event) {
        System.out.println("Condition Ok Annotation Application Event Triggered " + event.getMyField());
    }

    @EventListener(condition = "#event.myField.equals('Zumba') ne true ")
    public void onConditionFalse(OperationEvent event) {
        System.out.println("Condition Not Ok Annotation Application Event Triggered " + event.getMyField());
    }
}
