package io.github.rumplesteelskin.springboottutorials.main.scope;

public class MyRequestBean {
    public String getMyValue() {
        return "Request Scope: " + this.hashCode();
    }
}
