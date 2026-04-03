package com.fdm.SpringAssessment.service;

import com.fdm.SpringAssessment.models.Account;
import com.fdm.SpringAssessment.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public void createAccount(Account account) {
        accountRepository.save(account);
    }

    public Account findById(long accountId) {
        return accountRepository.findById(accountId);
    }

    public void deleteById(long accountId) {
        accountRepository.deleteById(accountId);
    }

    public ArrayList<Account> getAccounts() {
        return accountRepository.findAll();
    }
}
