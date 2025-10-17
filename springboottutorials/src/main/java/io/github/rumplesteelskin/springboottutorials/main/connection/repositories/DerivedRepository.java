package io.github.rumplesteelskin.springboottutorials.main.connection.repositories;

import io.github.rumplesteelskin.springboottutorials.main.connection.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DerivedRepository extends JpaRepository<Supplier, UUID> {
    Iterable<Supplier> findByName(String name);

    Iterable<Supplier> findByNameLike(String namePattern);

    Iterable<Supplier> findByNameStartingWith(String nameStartingWith);

    Iterable<Supplier> findByNameEndingWith(String nameEndingWith);

    Iterable<Supplier> findByTotalDebitEquals(double totalDebitEquals);

    Iterable<Supplier> findByTotalDebitGreaterThanEqual(double totalDebitGreaterThanEqual);

    Iterable<Supplier> findByTotalDebitBetween(double totalDebitMin, double totalDebitMax);

    Iterable<Supplier> findByNameLikeAndTotalDebitGreaterThanEqual(String namePattern, double totalDebitGreaterThanEqual);

}
