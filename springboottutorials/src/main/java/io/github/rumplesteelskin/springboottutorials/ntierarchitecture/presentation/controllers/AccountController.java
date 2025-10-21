package io.github.rumplesteelskin.springboottutorials.ntierarchitecture.presentation.controllers;

import io.github.rumplesteelskin.springboottutorials.ntierarchitecture.business.dtos.account.CreateAccountDTO;
import io.github.rumplesteelskin.springboottutorials.ntierarchitecture.business.dtos.account.ResponseAccountIdDTO;
import io.github.rumplesteelskin.springboottutorials.ntierarchitecture.business.services.interfaces.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("create")
    public ResponseAccountIdDTO create(@RequestBody CreateAccountDTO createAccountDTO) {
        ResponseAccountIdDTO responseAccountIdDTO = new ResponseAccountIdDTO();
        responseAccountIdDTO.setId(accountService.create(createAccountDTO));
        return responseAccountIdDTO;
    }
}
