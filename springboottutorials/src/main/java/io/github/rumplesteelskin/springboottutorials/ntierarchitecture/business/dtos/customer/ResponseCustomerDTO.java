package io.github.rumplesteelskin.springboottutorials.ntierarchitecture.business.dtos.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCustomerDTO {
    private UUID id;
    private String name;
    private double totalDebit;
}
