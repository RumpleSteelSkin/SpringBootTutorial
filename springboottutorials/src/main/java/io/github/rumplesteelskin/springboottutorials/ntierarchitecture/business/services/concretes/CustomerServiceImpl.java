package io.github.rumplesteelskin.springboottutorials.ntierarchitecture.business.services.concretes;

import io.github.rumplesteelskin.springboottutorials.ntierarchitecture.business.dtos.customer.CreateCustomerDTO;
import io.github.rumplesteelskin.springboottutorials.ntierarchitecture.business.dtos.customer.ResponseCustomerDTO;
import io.github.rumplesteelskin.springboottutorials.ntierarchitecture.business.services.interfaces.CustomerService;
import io.github.rumplesteelskin.springboottutorials.ntierarchitecture.configuration.errors.custom.NotFoundException;
import io.github.rumplesteelskin.springboottutorials.ntierarchitecture.data.entities.Customer;
import io.github.rumplesteelskin.springboottutorials.ntierarchitecture.data.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public String create(CreateCustomerDTO createCustomerDTO) {
        customerRepository.save(modelMapper.map(createCustomerDTO, Customer.class));
        return "Customer created successfully";
    }

    @Override
    public Iterable<ResponseCustomerDTO> getAll() {
        return modelMapper.map(customerRepository.findAll(), new TypeToken<Iterable<ResponseCustomerDTO>>() {
        }.getType());
    }

    @Override
    public ResponseCustomerDTO getById(UUID id) {
        return customerRepository.findById(id).map(customer -> modelMapper.map(customer, ResponseCustomerDTO.class))
                .orElseThrow(() -> new NotFoundException("Customer with id " + id + " not found"));
    }
}
