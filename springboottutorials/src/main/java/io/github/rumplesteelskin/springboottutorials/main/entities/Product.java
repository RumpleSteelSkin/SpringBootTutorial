package io.github.rumplesteelskin.springboottutorials.main.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@SuppressWarnings("unused")
public class Product {
    private long id;
    private String name;
    private double price;

    public Product(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(){}

}
