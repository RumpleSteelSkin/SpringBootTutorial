package io.github.rumplesteelskin.springboottutorials.main.connection.repositories;

import io.github.rumplesteelskin.springboottutorials.main.connection.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProductRepository extends CrudRepository<Product, UUID> {
}
