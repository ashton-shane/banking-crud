package com.fdm.SpringAssessment.controllers;

import com.fdm.SpringAssessment.DTO.AccountDTO;
import com.fdm.SpringAssessment.models.Account;
import com.fdm.SpringAssessment.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/accounts")
    public List<AccountDTO> getAccounts() {
        return accountService.getAccounts();
    }

    @GetMapping("/accounts/{accountId}")
    public AccountDTO findById(@PathVariable long accountId) {
        return accountService.findById(accountId);
    }

    @GetMapping("/accounts/create")
    public void createAccount(Account account) {
        accountService.createAccount(account);
    }

    @GetMapping("/accounts/delete/{accountId}")
    public void deleteAccount(@PathVariable long accountId) {
        accountService.deleteById(accountId);
    }

}
