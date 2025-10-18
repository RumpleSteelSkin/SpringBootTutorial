package io.github.rumplesteelskin.springboottutorials.main.connection.controllers;

import io.github.rumplesteelskin.springboottutorials.main.connection.entities.Department;
import io.github.rumplesteelskin.springboottutorials.main.connection.entities.Employee;
import io.github.rumplesteelskin.springboottutorials.main.connection.repositories.DepartmentRepository;
import io.github.rumplesteelskin.springboottutorials.main.connection.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @SuppressWarnings("SameReturnValue")
    @GetMapping("generate/{departmentId}")
    public String generate(@PathVariable("departmentId") UUID departmentId) {
        Department department = departmentRepository.findById(departmentId).orElse(null);
        int dId = Integer.parseInt(Objects.requireNonNull(department).getName().split(" ")[1]);
        for (int j = 1; j < (int) (Math.random() * 100); j++) {
            Employee employee = new Employee();
            employee.setName("Employee D: " + dId + "-" + j);
            employee.setSalary((j * dId * 1000));
            employee.setDepartment(department);
            employeeRepository.save(employee);
        }
        return "Employee generated successfully";
    }

    @GetMapping("find-by-id/{id}")
    public String findEmployeeById(@PathVariable("id") String id) {
        Optional<Employee> optional = employeeRepository.findById(UUID.fromString(id));
        if (optional.isEmpty()) {
            throw new RuntimeException("Employee with id " + id + " not found");
        }
        Employee employee = optional.get();
        return employee.getDepartment().getName();
    }

    @GetMapping("list-by-department/{dep-id}")
    public String getEmployeesByDepartment(@PathVariable("dep-id") String id) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Employee employee : employeeRepository.findByDepartment(UUID.fromString(id))) {
            stringBuilder.append(employee.getName()).append("\n");
        }
        return stringBuilder.toString();
    }
}
