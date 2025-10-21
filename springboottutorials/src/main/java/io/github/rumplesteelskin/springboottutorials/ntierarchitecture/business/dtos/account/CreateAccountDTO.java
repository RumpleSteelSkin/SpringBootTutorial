package io.github.rumplesteelskin.springboottutorials.ntierarchitecture.business.dtos.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountDTO {
    private String name;
    private double totalBalance;
}
