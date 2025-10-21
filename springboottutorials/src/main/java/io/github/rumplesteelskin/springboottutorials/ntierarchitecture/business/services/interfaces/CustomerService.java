package io.github.rumplesteelskin.springboottutorials.ntierarchitecture.business.services.interfaces;

import io.github.rumplesteelskin.springboottutorials.ntierarchitecture.business.dtos.customer.CreateCustomerDTO;
import io.github.rumplesteelskin.springboottutorials.ntierarchitecture.business.dtos.customer.ResponseCustomerDTO;
import io.github.rumplesteelskin.springboottutorials.ntierarchitecture.business.dtos.customer.ResponseCustomerWithAddressDTO;

import java.util.UUID;

@SuppressWarnings("SameReturnValue")
public interface CustomerService {
    String create(CreateCustomerDTO createCustomerDTO);

    Iterable<ResponseCustomerDTO> getAll();

    ResponseCustomerDTO getById(UUID id);

    ResponseCustomerWithAddressDTO getByIdWithAddress(UUID id);
}
