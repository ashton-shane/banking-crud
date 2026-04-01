package com.fdm.SpringAssessment.Account;

import com.fdm.SpringAssessment.models.*;
import org.junit.jupiter.api.Test;

import static com.fdm.SpringAssessment.enums.AccountType.CHECKING;
import static com.fdm.SpringAssessment.enums.AccountType.SAVINGS;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAccount {
    @Test
    public void returnsCorrectAttributes_whenCreateSavingsAccountObjectWithAttributes(){

        Address address = Address.builder()
                .city("Singapore")
                .postalCode("151515")
                .streetNumber("64")
                .build();
        Person person = new Person("Ash", address);
        Account account = new SavingsAccount(50.00, SAVINGS, person);
        assertEquals(50.00, account.getBalance());
        assertEquals(SAVINGS, account.getAccountType());
        assertEquals(person, account.getCustomer());
        assertEquals("Ash", account.getCustomer().getName());
    }

    @Test
    public void returnsCorrectAttributes_whenCreateCheckingAccountObjectWithAttributes(){
        Address address = Address.builder()
                .city("Singapore")
                .postalCode("151515")
                .streetNumber("64")
                .build();
        Person person = new Person("Bob", address);
        Account account = new SavingsAccount(100.00, CHECKING, person);

        assertEquals(100.00, account.getBalance());
        assertEquals(CHECKING, account.getAccountType());
        assertEquals(person, account.getCustomer());
        assertEquals("Bob", account.getCustomer().getName());
    }
}
