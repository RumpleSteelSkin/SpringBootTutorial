package io.github.rumplesteelskin.springboottutorials.ntierarchitecture.business.services.concretes;

import io.github.rumplesteelskin.springboottutorials.ntierarchitecture.business.dtos.account.CreateAccountDTO;
import io.github.rumplesteelskin.springboottutorials.ntierarchitecture.business.services.interfaces.AccountService;
import io.github.rumplesteelskin.springboottutorials.ntierarchitecture.data.entities.Account;
import io.github.rumplesteelskin.springboottutorials.ntierarchitecture.data.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    @Override
    public String create(CreateAccountDTO createAccountDTO) {
        return accountRepository.save(modelMapper.map(createAccountDTO, Account.class)).getId().toString();
    }
}

