package com.fdm.SpringAssessment.controllers;

import com.fdm.SpringAssessment.models.Account;
import com.fdm.SpringAssessment.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    public ArrayList<Account> getAccounts() {
        return accountService.getAccounts();
    }

    @GetMapping("/{accountId}")
    public Account findById(@PathVariable long accountId) {
        return accountService.findById(accountId);
    }

    @GetMapping
    public void createAccount(Account account) {
        accountService.createAccount(account);
    }

    @GetMapping
    public void deleteAccount(long accountId) {
        accountService.deleteById(accountId);
    }
}
