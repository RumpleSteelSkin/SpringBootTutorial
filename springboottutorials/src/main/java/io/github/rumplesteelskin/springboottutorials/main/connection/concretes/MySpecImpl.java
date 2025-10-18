package io.github.rumplesteelskin.springboottutorials.main.connection.concretes;

import io.github.rumplesteelskin.springboottutorials.main.connection.interfaces.MySpec;

public class MySpecImpl implements MySpec {
    @Override
    public String myMethod(String input) {
        return "Realiser " + input;
    }
}
