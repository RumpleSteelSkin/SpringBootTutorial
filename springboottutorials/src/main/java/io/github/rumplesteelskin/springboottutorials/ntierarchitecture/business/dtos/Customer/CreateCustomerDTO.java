package io.github.rumplesteelskin.springboottutorials.ntierarchitecture.business.dtos.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCustomerDTO {
    private String name;
    private double totalDebit;
}
