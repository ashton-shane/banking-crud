package com.fdm.SpringAssessment.controllers;

import com.fdm.SpringAssessment.DTO.AccountDTO;
import com.fdm.SpringAssessment.DTO.AmountDTO;
import com.fdm.SpringAssessment.models.Account;
import com.fdm.SpringAssessment.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    public List<AccountDTO> getAccounts() {
        return accountService.getAccounts();
    }

    @GetMapping("/{accountId}")
    public AccountDTO findById(@PathVariable long accountId) {
        return accountService.findById(accountId);
    }

    @PostMapping("/create")
    public void createAccount(@RequestBody AccountDTO accountDTO) {
        System.out.println("DTO received: " + accountDTO);
        accountService.createAccount(accountDTO);
    }

    @DeleteMapping("/{accountId}")
    public void deleteAccount(@PathVariable long accountId) {
        accountService.deleteById(accountId);
    }

    @PutMapping("/deposit/{accountId}")
    public void deposit(@PathVariable long accountId, @RequestBody AmountDTO amountDTO) {
        double amount = amountDTO.getAmount();
        accountService.deposit(accountId, amount);
    }

    @PutMapping("/withdraw/{accountId}")
    public void withdraw(@PathVariable long accountId, @RequestBody AmountDTO amountDTO) {
        double amount = amountDTO.getAmount();
        accountService.withdraw(accountId, amount);
    }

}
