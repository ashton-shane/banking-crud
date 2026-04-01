package com.fdm.SpringAssessment.Account;

import com.fdm.SpringAssessment.models.*;
import org.junit.jupiter.api.Test;

import static com.fdm.SpringAssessment.enums.AccountType.CHECKING;
import static com.fdm.SpringAssessment.enums.AccountType.SAVINGS;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAccount {
    @Test
    public void returnsCorrectAttributes_whenCreateSavingsAccountObjectWithAttributes(){

        Person person = Person.builder()
                .name("Ash")
                .city("Singapore")
                .postalCode("640555")
                .build();
        Account account = new SavingsAccount(50.00, SAVINGS, person);
        assertEquals(50.00, account.getBalance());
        assertEquals(SAVINGS, account.getAccountType());
        assertEquals(person, account.getCustomer());
        assertEquals("Ash", account.getCustomer().getName());
    }

    @Test
    public void returnsCorrectAttributes_whenCreateCheckingAccountObjectWithAttributes(){
        Person person = Person.builder()
                .name("Bob")
                .city("Singapore")
                .postalCode("123543")
                .build();
        Account account = new SavingsAccount(100.00, CHECKING, person);

        assertEquals(100.00, account.getBalance());
        assertEquals(CHECKING, account.getAccountType());
        assertEquals(person, account.getCustomer());
        assertEquals("Bob", account.getCustomer().getName());
    }
}
