package io.github.rumplesteelskin.springboottutorials.main.connection.controllers;


import io.github.rumplesteelskin.springboottutorials.main.connection.entities.Department;
import io.github.rumplesteelskin.springboottutorials.main.connection.entities.Employee;
import io.github.rumplesteelskin.springboottutorials.main.connection.repositories.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentRepository departmentRepository;

    @SuppressWarnings("SameReturnValue")
    @GetMapping("generate")
    public String generateDepartment() {
        for (int i = 1; i < 11; i++) {
            Department department = new Department();
            department.setName("Department " + i);
            department.setEmployees(new ArrayList<>());
            for (int j = 1; j < (int) (Math.random() * 100); j++) {
                Employee employee = new Employee();
                employee.setName("Employee D: " + i + "-" + j);
                employee.setSalary((j * i * 1000));
                employee.setDepartment(department);
                department.getEmployees().add(employee);
            }
            departmentRepository.save(department);
        }
        return "Successfully generated department";
    }

    @GetMapping("find-by-id/{id}")
    public String findDepartmentById(@PathVariable("id") String id) {
        Optional<Department> optional = departmentRepository.findById(UUID.fromString(id));
        if (optional.isEmpty()) {
            throw new RuntimeException("Department with id " + id + " not found");
        }
        Department department = optional.get();
        StringBuilder stringBuilder = new StringBuilder();
        double totalSalary = 0;
        for (Employee employee : department.getEmployees()) {
            stringBuilder.append(employee.getName()).append(" ").append(employee.getSalary()).append("\n");
            totalSalary += employee.getSalary();
        }
        stringBuilder.append(totalSalary).append("\n");
        return stringBuilder.toString();
    }

}
