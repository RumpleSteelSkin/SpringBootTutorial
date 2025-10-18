package io.github.rumplesteelskin.springboottutorials.main.connection.concretes;

import lombok.Data;

@Data
public class MyBean {
    public long id;
    public String name;
    public double salary;

    public void initializeBean() {
        System.out.println("Initializing bean");
    }

    public void finalizeBean() {
        System.out.println("Finalizing bean");
    }
}
