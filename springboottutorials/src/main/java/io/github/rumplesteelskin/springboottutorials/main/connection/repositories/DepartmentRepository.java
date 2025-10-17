package io.github.rumplesteelskin.springboottutorials.main.connection.repositories;

import io.github.rumplesteelskin.springboottutorials.main.connection.entities.Department;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DepartmentRepository extends CrudRepository<Department, UUID> { }
