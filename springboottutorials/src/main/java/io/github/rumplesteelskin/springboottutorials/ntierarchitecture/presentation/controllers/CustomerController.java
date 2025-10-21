package io.github.rumplesteelskin.springboottutorials.ntierarchitecture.presentation.controllers;

import io.github.rumplesteelskin.springboottutorials.ntierarchitecture.business.dtos.customer.CreateCustomerDTO;
import io.github.rumplesteelskin.springboottutorials.ntierarchitecture.business.dtos.customer.ResponseCustomerDTO;
import io.github.rumplesteelskin.springboottutorials.ntierarchitecture.business.services.interfaces.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("create")
    public String create(@RequestBody CreateCustomerDTO createCustomerDTO) {
        return customerService.create(createCustomerDTO);
    }

    @GetMapping("getAll")
    public Iterable<ResponseCustomerDTO> getAll() {
        return customerService.getAll();
    }

    @GetMapping("get/{id}")
    public ResponseCustomerDTO getById(@PathVariable UUID id) {
        return customerService.getById(id);
    }
}
