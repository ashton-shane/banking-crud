package com.fdm.SpringAssessment.service;

import com.fdm.SpringAssessment.DTO.AccountDTO;
import com.fdm.SpringAssessment.DTO.CustomerDTO;
import com.fdm.SpringAssessment.controllers.CustomerController;
import com.fdm.SpringAssessment.enums.AccountType;
import com.fdm.SpringAssessment.enums.CustomerType;
import com.fdm.SpringAssessment.models.Account;
import com.fdm.SpringAssessment.models.CheckingAccount;
import com.fdm.SpringAssessment.models.Customer;
import com.fdm.SpringAssessment.models.SavingsAccount;
import com.fdm.SpringAssessment.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class AccountService {
    @Autowired
    CustomerService customerService;

    private final AccountRepository accountRepository;

    public void createAccount(AccountDTO accountDto) {
        Account account = toAccount(accountDto, CustomerType.PERSON);
        accountRepository.save(account);
    }

    public AccountDTO findById(long accountId) {
        Account foundAcc = accountRepository.findById(accountId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found"));
        return toDTO(foundAcc);
    }

    public void deleteById(long accountId) {
        accountRepository.deleteById(accountId);
    }

    public List<AccountDTO> getAccounts() {
        return accountRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public AccountDTO toDTO(Account account) {
        return AccountDTO.builder()
                .id(account.getId())
                .balance(account.getBalance())
                .accountType(account.getAccountType())
                .customerId(account.getCustomer().getId())
                .customerName(account.getCustomer().getName())
                .build();
    }

    public Account toAccount(AccountDTO dto, CustomerType customerType) {
        Account account = switch (dto.getAccountType()) {
            case SAVINGS -> new SavingsAccount();
            case CHECKING -> new CheckingAccount();
        };

        Customer customer = customerService.findById(dto.getCustomerId());
        account.setCustomer(customer);
        account.setBalance(dto.getBalance());
        account.setAccountType(dto.getAccountType());

        return account;
    }
}
