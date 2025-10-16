package io.github.rumplesteelskin.springboottutorials.main.connection;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@SuppressWarnings("unused")
@Entity
public class Product {

    @Id
    private UUID id;
    private String name;
    private double price;

    public Product(UUID id, double price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public Product() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
