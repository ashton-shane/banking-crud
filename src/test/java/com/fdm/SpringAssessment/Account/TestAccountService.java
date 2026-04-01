package com.fdm.SpringAssessment.Account;

import com.fdm.SpringAssessment.enums.AccountType;
import com.fdm.SpringAssessment.models.Account;
import com.fdm.SpringAssessment.models.Address;
import com.fdm.SpringAssessment.models.Person;
import com.fdm.SpringAssessment.models.SavingsAccount;
import com.fdm.SpringAssessment.repository.AccountRepository;
import com.fdm.SpringAssessment.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestAccountService {
    @Mock
    AccountRepository accountRepository;

    @InjectMocks
    AccountService accountService;

    Person person;
    Address address;
    Account account;

    @BeforeEach
    public void test_config() {
        address = Address.builder()
                .city("Singapore")
                .postalCode("151515")
                .streetNumber("64")
                .build();
        person = new Person("Ash", address);
        account = new SavingsAccount(50.00, AccountType.SAVINGS, person);
    }

    @Test
    public void verifyCallOnce_whenCallingFindById() {
        accountService.findById(account.getId());
        verify(accountRepository).findById(account.getId());
    }

    @Test
    public void returnsBalance_whenCallingFindById() {
        long accountId = account.getId();
        when(accountRepository.findById(accountId)).thenReturn(account);
        assertEquals(50.00, accountService.findById(accountId).getBalance());
    }

    @Test
    public void verifyCallOnce_whenCallingDeleteById() {
        accountService.deleteById(account.getId());
        verify(accountRepository).deleteById(account.getId());
    }

    @Test
    public void returnsArrayOfSizeThree_whenCallingGetAccounts() {
        Address address1 = mock(Address.class);
        Address address2 = mock(Address.class);

        Person person1 = new Person("Ben", address1);
        Person person2 = new Person("Vivian", address2);

        ArrayList<Account> mockAccounts = new ArrayList<>(Arrays.asList(
                account,
                new SavingsAccount(100.00, AccountType.SAVINGS, person1),
                new SavingsAccount(200.00, AccountType.SAVINGS, person2)
        ));

        when(accountRepository.findAll()).thenReturn(mockAccounts);
        assertEquals(3, accountService.getAccounts().size());
    }

    @Test
    public void verifyCallOnce_whenCallingCreateAccount() {
        accountService.createAccount(account);
        verify(accountRepository).save(account);
    }
}
