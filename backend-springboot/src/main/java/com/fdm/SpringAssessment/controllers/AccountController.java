package com.fdm.SpringAssessment.controllers;

import com.fdm.SpringAssessment.DTO.AccountDTO;
import com.fdm.SpringAssessment.models.Account;
import com.fdm.SpringAssessment.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
@org.springframework.web.bind.annotation.CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/accounts")
    public List<AccountDTO> getAccounts() {
        return accountService.getAccounts();
    }

    // singular account route requested: /account/{id}
    @GetMapping("/account/{accountId}")
    public Account findById(@PathVariable long accountId) {
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

    @org.springframework.web.bind.annotation.PostMapping("/accounts/{accountId}/update")
    public void updateAccountBalance(@PathVariable long accountId, @org.springframework.web.bind.annotation.RequestBody Account payload) {
        Account existing = accountService.findById(accountId);
        if (existing != null) {
            existing.setBalance(payload.getBalance());
            accountService.createAccount(existing);
        }
    }
}
