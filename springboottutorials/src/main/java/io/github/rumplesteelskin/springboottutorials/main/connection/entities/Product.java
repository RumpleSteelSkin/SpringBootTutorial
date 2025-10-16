package io.github.rumplesteelskin.springboottutorials.main.connection.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
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

}
