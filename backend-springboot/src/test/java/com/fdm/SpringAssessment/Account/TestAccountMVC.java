package com.fdm.SpringAssessment.Account;

import com.fdm.SpringAssessment.DTO.AccountDTO;
import com.fdm.SpringAssessment.enums.AccountType;
import com.fdm.SpringAssessment.models.Account;
import com.fdm.SpringAssessment.models.Address;
import com.fdm.SpringAssessment.models.Person;
import com.fdm.SpringAssessment.models.SavingsAccount;
import com.fdm.SpringAssessment.repository.AccountRepository;
import com.fdm.SpringAssessment.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestRestTemplate
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
    @Test
    public void returnsListOfAccounts_whenCallingAccountsEndpoint() {
        // act
        ResponseEntity<AccountDTO[]> response =
                restTemplate.getForEntity("/accounts", AccountDTO[].class);

        // assert status
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // assert body
        AccountDTO[] accounts = response.getBody();
        assertNotNull(accounts);
        assertTrue(accounts.length > 0);

        // assert content
        assertEquals(1000.0, accounts[0].getBalance());
        assertEquals(AccountType.SAVINGS, accounts[0].getAccountType());
        assertEquals("Ash", accounts[0].getCustomerName());
    }
}
