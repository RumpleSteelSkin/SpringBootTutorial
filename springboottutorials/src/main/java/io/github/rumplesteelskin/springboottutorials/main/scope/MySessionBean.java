package io.github.rumplesteelskin.springboottutorials.main.scope;

public class MySessionBean {
    public String getMyValue() {
        return "Session Scope: " + this.hashCode();
    }
}
