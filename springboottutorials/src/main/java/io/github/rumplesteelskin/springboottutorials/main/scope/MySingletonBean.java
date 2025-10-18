package io.github.rumplesteelskin.springboottutorials.main.scope;

public class MySingletonBean {
    public String getMyValue() {
        return "Singleton Scope: " + this.hashCode();
    }
}


