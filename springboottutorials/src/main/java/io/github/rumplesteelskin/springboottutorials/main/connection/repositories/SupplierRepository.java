package io.github.rumplesteelskin.springboottutorials.main.connection.repositories;

import io.github.rumplesteelskin.springboottutorials.main.connection.entities.Supplier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

@SuppressWarnings("unused")
public interface SupplierRepository extends CrudRepository<Supplier, UUID> {

    @Query("SELECT s FROM Supplier s")
    List<Supplier> findSuppliers();

    @Query("""
            SELECT s
            FROM Supplier s
            WHERE s.name
            LIKE :namePattern
            """)
    List<Supplier> findSuppliersLike(@Param("namePattern") String supplierNamePattern);

    @Query("""
            SELECT s FROM Supplier s
            WHERE s.totalDebit > :debitMin
            """)
    List<Supplier> findSuppliersMin(@Param("debitMin") double totalDebitMin);

    @Query("""
            SELECT s FROM Supplier s
            WHERE
                s.totalDebit > :debitMin
                AND
                s.name LIKE :namePattern
            """)
    List<Supplier> findSuppliersCriteria(@Param("debitMin") double totalDebitMin, @Param("namePattern") String supplierNamePattern);

    @Query("""
                SELECT s FROM Supplier s
                WHERE s.name = :name
            """)
    Supplier findSupplierByName(@Param("name") String name);

    @Query("""
            SELECT AVG(s.totalDebit) FROM Supplier s
            WHERE s.totalDebit > :debitMin
            """)
    double findSuppliersMinAverage(@Param("debitMin") double totalDebitMin);
}
