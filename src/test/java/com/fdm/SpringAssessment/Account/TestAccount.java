package com.fdm.SpringAssessment.Account;

import com.fdm.SpringAssessment.models.Account;
import com.fdm.SpringAssessment.models.Customer;
import com.fdm.SpringAssessment.models.Person;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAccount {
    @Test
    public void returnsCorrectAttributes_whenCreateAccountObjectWithAttributes(){

        Person person = Person.builder()
                .name("Ash")
                .city("Singapore")
                .postalCode("640555")
                .build();
        Account account = new Account(50.00, person);
        assertEquals(50.00, account.getBalance());
        assertEquals(person, account.getCustomer());
        assertEquals("Ash", account.getCustomer().getName());
    }
}
