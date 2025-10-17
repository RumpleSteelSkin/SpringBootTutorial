package io.github.rumplesteelskin.springboottutorials.main.connection.repositories;

import io.github.rumplesteelskin.springboottutorials.main.connection.entities.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface ParticularRepository extends PagingAndSortingRepository<Supplier, UUID> {

    @Query("""
            SELECT s FROM Supplier s
            WHERE s.totalDebit > :debitMin
            """)
    Page<Supplier> findSuppliersMinAndPageable(@Param("debitMin") double totalDebitMin, Pageable pageable);
}
