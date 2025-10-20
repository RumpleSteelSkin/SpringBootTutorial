package io.github.rumplesteelskin.springboottutorials.main.events.application;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@SuppressWarnings("unused")
public class OperationEvent extends ApplicationEvent {

    @Getter
    @Setter
    private String myField;

    public OperationEvent(Object source) {
        super(source);
    }

    public OperationEvent(Object source, String myField) {
        super(source);
        this.myField = myField;
    }
}
