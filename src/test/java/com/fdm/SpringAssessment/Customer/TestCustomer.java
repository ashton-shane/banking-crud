package com.fdm.SpringAssessment.Customer;

import com.fdm.SpringAssessment.models.Company;
import com.fdm.SpringAssessment.models.Customer;
import com.fdm.SpringAssessment.models.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCustomer {
    @Test
    public void returnsCorrectAttributes_whenCreateAPersonObjectWithAttributes(){
        Person person = Person.builder()
                .name("Ash")
                .city("Singapore")
                .postalCode("640555")
                .build();
        assertEquals("Ash", person.getName());
        assertEquals("640555", person.getPostalCode());
    }

    @Test
    public void returnsCorrectAttributes_whenCreateACompanyObjectWithAttributes(){
        Company company = Company.builder()
                .name("FDM")
                .city("Singapore")
                .postalCode("123000")
                .build();
        assertEquals("FDM", company.getName());
        assertEquals("123000", company.getPostalCode());
    }

}
