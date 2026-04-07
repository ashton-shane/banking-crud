package com.fdm.SpringAssessment.Account;

import com.fdm.SpringAssessment.enums.AccountType;
import com.fdm.SpringAssessment.models.Account;
import com.fdm.SpringAssessment.models.Address;
import com.fdm.SpringAssessment.models.Person;
import com.fdm.SpringAssessment.models.SavingsAccount;
import com.fdm.SpringAssessment.repository.AccountRepository;
import com.fdm.SpringAssessment.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestAccountMVC {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    public void setup() {
        // clean DB (order matters)
        accountRepository.deleteAll();
        customerRepository.deleteAll();

        // create test data
        Address address = Address.builder()
                .blockNumber("42")
                .roadName("Serangoon Ave")
                .fullAddress("42 Serangoon Ave, SG")
                .postalCode("123456")
                .building("Test Building")
                .build();

        Person person = new Person("Ash", address);
        customerRepository.save(person);

        Account account = new SavingsAccount(1000.0, AccountType.SAVINGS, person);
        accountRepository.save(account);
    }
}
