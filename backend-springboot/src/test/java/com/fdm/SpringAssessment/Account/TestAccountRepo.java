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
                .building("Serangoon Gardens Estate")
                .blockNumber("42")
                .roadName("Serangoon Avenue 2")
                .fullAddress("42 Serangoon Avenue 2, Singapore 556142")
                .postalCode("556142")
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
                .building("Bishan Point")
                .blockNumber("9")
                .roadName("Bishan Street 14")
                .fullAddress("9 Bishan Street 14, Singapore 579786")
                .postalCode("579786")
                .build();
        Person person1 = new Person("Ash", address1);

        Address address2 = Address.builder()
                .building("Jurong East Central")
                .blockNumber("135")
                .roadName("Jurong Gateway Road")
                .fullAddress("135 Jurong Gateway Road, Singapore 600135")
                .postalCode("600135")
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
                .building("Serangoon Gardens Estate")
                .blockNumber("42")
                .roadName("Serangoon Avenue 2")
                .fullAddress("42 Serangoon Avenue 2, Singapore 556142")
                .postalCode("556142")
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
