package io.github.rumplesteelskin.springboottutorials.main.scope;

public class MyApplicationBean {
    public String getMyValue() {
        return "Application Scope: " + this.hashCode();
    }
}
