package io.github.rumplesteelskin.springboottutorials.main.connection.repositories;

import io.github.rumplesteelskin.springboottutorials.main.connection.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface EmployeeRepository extends CrudRepository<Employee, UUID> {
    @Query("SELECT e FROM Employee e WHERE e.department.id = :departmentId")
    List<Employee> findByDepartment(@Param("departmentId") UUID departmentId);
}
