package io.github.rumplesteelskin.springboottutorials.main.connection;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface IProductRepository extends CrudRepository<Product, UUID> {
}
