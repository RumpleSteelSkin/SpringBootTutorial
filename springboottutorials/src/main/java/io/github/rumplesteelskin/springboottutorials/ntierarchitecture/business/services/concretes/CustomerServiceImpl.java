package io.github.rumplesteelskin.springboottutorials.ntierarchitecture.business.services.concretes;

import io.github.rumplesteelskin.springboottutorials.ntierarchitecture.business.dtos.Customer.CreateCustomerDTO;
import io.github.rumplesteelskin.springboottutorials.ntierarchitecture.business.services.interfaces.CustomerService;
import io.github.rumplesteelskin.springboottutorials.ntierarchitecture.data.entities.Customer;
import io.github.rumplesteelskin.springboottutorials.ntierarchitecture.data.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public String create(CreateCustomerDTO createCustomerDTO) {
        customerRepository.save(modelMapper.map(createCustomerDTO, Customer.class));
        return "Customer created successfully";
    }
}
