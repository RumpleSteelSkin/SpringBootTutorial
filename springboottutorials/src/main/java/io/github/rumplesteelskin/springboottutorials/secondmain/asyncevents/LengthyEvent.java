package io.github.rumplesteelskin.springboottutorials.secondmain.asyncevents;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

public class LengthyEvent extends ApplicationEvent {
    @Getter
    @Setter
    private String myField;

    public LengthyEvent(Object source, String aLong) {
        super(source);
        myField = aLong;
    }
}
