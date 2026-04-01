package com.fdm.SpringAssessment.Account;

import com.fdm.SpringAssessment.enums.AccountType;
import com.fdm.SpringAssessment.models.Account;
import com.fdm.SpringAssessment.models.Address;
import com.fdm.SpringAssessment.models.Person;
import com.fdm.SpringAssessment.models.SavingsAccount;
import com.fdm.SpringAssessment.repository.AccountRepository;
import com.fdm.SpringAssessment.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class TestAccountRepo {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void returnsAccountBalance_whenFindingAccountById() {
        Address address = Address.builder()
                .city("Singapore")
                .postalCode("151515")
                .streetNumber("64")
                .build();
        Person person = new Person("Ash", address);
        customerRepository.save(person);

        Account account = new SavingsAccount(50.00, AccountType.SAVINGS, person);
        accountRepository.save(account);
        Account found = accountRepository.findById(account.getId());

        assertEquals(50.00, found.getBalance());
    }

    @Test
    public void returnsTrue_whenCreatingAndSavingNewAccounts() {
        Address address1 = Address.builder()
                .city("Singapore")
                .postalCode("151515")
                .streetNumber("64")
                .build();
        Person person1 = new Person("Ash", address1);

        Address address2 = Address.builder()
                .city("Singapore")
                .postalCode("222222")
                .streetNumber("55")
                .build();
        Person person2 = new Person("Bob", address2);

        customerRepository.save(person1);
        customerRepository.save(person2);

        Account account1 = new SavingsAccount(100.00, AccountType.SAVINGS, person1);
        Account account2 = new SavingsAccount(200.00, AccountType.SAVINGS, person2);

        accountRepository.save(account1);
        accountRepository.save(account2);

        assertTrue(account1.getId() > 0);
        assertTrue(account2.getId() > 0);
    }

    @Test
    public void returnsTrue_whenRemovingAccountByAccountId() {
        Address address = Address.builder()
                .city("Singapore")
                .postalCode("151515")
                .streetNumber("64")
                .build();
        Person person = new Person("Ash", address);
        customerRepository.save(person);

        Account account = new SavingsAccount(75.00, AccountType.SAVINGS, person);
        accountRepository.save(account);
        long accountId = account.getId();
        accountRepository.deleteById(accountId);
        assertNull(accountRepository.findById(accountId));
    }
}
