package io.github.rumplesteelskin.springboottutorials.main.scope;

public class MyPrototypeBean {
    public String getMyValue() {
        return "Prototype Scope: " + this.hashCode();
    }
}
