package io.github.rumplesteelskin.springboottutorials.ntierarchitecture.business.services.interfaces;

import io.github.rumplesteelskin.springboottutorials.ntierarchitecture.business.dtos.account.CreateAccountDTO;

public interface AccountService {
    String create(CreateAccountDTO createAccountDTO);
}
