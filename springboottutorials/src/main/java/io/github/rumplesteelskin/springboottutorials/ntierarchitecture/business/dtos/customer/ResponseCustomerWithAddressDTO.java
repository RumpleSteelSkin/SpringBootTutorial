package io.github.rumplesteelskin.springboottutorials.ntierarchitecture.business.dtos.customer;

import io.github.rumplesteelskin.springboottutorials.ntierarchitecture.business.dtos.address.ResponseAddressDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCustomerWithAddressDTO {
    private UUID id;
    private String name;
    private double totalDebit;
    private ResponseAddressDTO address;
}
