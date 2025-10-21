package io.github.rumplesteelskin.springboottutorials.ntierarchitecture.presentation.controllers;

import io.github.rumplesteelskin.springboottutorials.ntierarchitecture.business.dtos.Customer.CreateCustomerDTO;
import io.github.rumplesteelskin.springboottutorials.ntierarchitecture.business.services.interfaces.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("create")
    public String create(@RequestBody CreateCustomerDTO createCustomerDTO) {
        return customerService.create(createCustomerDTO);
    }
}
