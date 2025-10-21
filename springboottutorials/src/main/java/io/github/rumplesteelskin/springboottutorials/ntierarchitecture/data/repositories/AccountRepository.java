package io.github.rumplesteelskin.springboottutorials.ntierarchitecture.data.repositories;

import io.github.rumplesteelskin.springboottutorials.ntierarchitecture.data.entities.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AccountRepository extends CrudRepository<Account, UUID> {
}
