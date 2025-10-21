package io.github.rumplesteelskin.springboottutorials.ntierarchitecture.data.repositories;

import io.github.rumplesteelskin.springboottutorials.ntierarchitecture.data.entities.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CustomerRepository extends CrudRepository<Customer, UUID> {
}
