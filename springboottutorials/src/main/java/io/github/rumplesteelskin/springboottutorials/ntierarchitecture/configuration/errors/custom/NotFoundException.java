package io.github.rumplesteelskin.springboottutorials.ntierarchitecture.configuration.errors.custom;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
