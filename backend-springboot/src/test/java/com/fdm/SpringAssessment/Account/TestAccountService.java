package com.fdm.SpringAssessment.Account;

import com.fdm.SpringAssessment.DTO.AccountDTO;
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
import java.util.Optional;

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
                .building("Clementi West Arc")
                .blockNumber("88")
                .roadName("Clementi Avenue 6")
                .fullAddress("88 Clementi Avenue 6, Singapore 120088")
                .postalCode("120088")
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
        when(accountRepository.findById(accountId)).thenReturn(Optional.ofNullable(account));
        assertEquals(50.00, accountService.findById(accountId).orElseThrow().getBalance());
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
    var dtos = accountService.getAccounts();
    assertEquals(3, dtos.size());
    // verify each dto contains flattened customer info
    assertEquals(mockAccounts.get(0).getCustomer().getId(), dtos.get(0).getCustomerId());
    assertEquals(mockAccounts.get(0).getCustomer().getName(), dtos.get(0).getCustomerName());
    }

    @Test
    public void verifyCallOnce_whenCallingCreateAccount() {
        AccountDTO accountDTO = mock(AccountDTO.class);
        accountService.createAccount(accountDTO);
        verify(accountRepository).save(account);
    }
}
