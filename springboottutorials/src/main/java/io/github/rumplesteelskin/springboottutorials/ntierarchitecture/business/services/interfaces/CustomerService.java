package io.github.rumplesteelskin.springboottutorials.ntierarchitecture.business.services.interfaces;

import io.github.rumplesteelskin.springboottutorials.ntierarchitecture.business.dtos.Customer.CreateCustomerDTO;

public interface CustomerService {
    String create(CreateCustomerDTO createCustomerDTO);
}
